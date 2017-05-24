package com.product.utils;


import com.yonyou.iuap.tenant.sdk.TenantCenter;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.*;


/**
 * 新建租户工具类
 * Created by congdayong on 16/8/8.
 */
public class TenantInitUtil {

    private final static Logger logger = LoggerFactory.getLogger(TenantInitUtil.class);

//    //初始化租户数据库

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantAdminUserCode() {
        return tenantAdminUserCode;
    }

    public void setTenantAdminUserCode(String tenantAdminUserCode) {
        this.tenantAdminUserCode = tenantAdminUserCode;
    }



//    initTenantDB(tenantId);
//    //设置租户信息
//    InvocationInfoProxy.setTenantid(tenantId);

    private String tenantId;
    private String tenantAdminUserCode;

    public static final String classpath = "/usr/local/tomcat7/webapps/ROOT/WEB-INF/classes/";

    public static final Object lockedTenant = new Object();
    public static final List<String> lockedTenantIds = new ArrayList<String>();

    /**
     * 检查数据库中是否含有该租户
     * @param tenantId
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static boolean checkTenantDatabase(String tenantId) throws IOException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Connection conn = null;
        Statement stmt = null;

        Properties props = Resources.getResourceAsProperties("jdbc.properties");
        String url = props.getProperty("url");
        String driver = props.getProperty("driver");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url, username, password);
        //先建库
        stmt = conn.createStatement();
        stmt.execute("show databases");

        ResultSet rs = stmt.getResultSet();

        List<String> list = new ArrayList<String>();
        //我知道这个只用一列,因此直接加载
        while (rs.next()){
            list.add(rs.getString(1));
        }
        if (list.contains(tenantId))
            return true;

        return false;
    }

    public static String getDefaultTenant(){
        try {
            Properties props = Resources.getResourceAsProperties("jdbc.properties");
            return props.getProperty("tenantId");
        }catch (Exception e){
            
        }
        return "";
    }

    public static String getDefaultUser(){
        try {
            Properties props = Resources.getResourceAsProperties("jdbc.properties");
            return props.getProperty("tenantAdminUserCode");
        }catch (Exception e){
            
        }
        return "";
    }

    public static Map<String, String> getTenants(String phone) throws Exception {
        Map<String, String> result = new HashMap<String, String>();
        String tenantInfo = TenantCenter.getAuthTenantInfo(phone, "ssc_baozhang");

        if (!StringUtils.isEmpty(tenantInfo)) {
            JSONObject info = JSONObject.fromObject(tenantInfo);
            if (info.has("status") && "1".equals(info.getString("status"))){
                JSONArray tenants = info.getJSONArray("tenants");
                Connection conn = null;
                Statement stmt = null;

                Properties props = Resources.getResourceAsProperties("jdbc.properties");
                String url = props.getProperty("url");
                String driver = props.getProperty("driver");
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url, username, password);
                //先建库
                stmt = conn.createStatement();
                stmt.execute("show databases");

                ResultSet rs = stmt.getResultSet();

                List<String> list = new ArrayList<String>();
                //我知道这个只用一列,因此直接加载
                while (rs.next()){
                    list.add(rs.getString(1));
                }

                rs.close();
                stmt.close();
                conn.close();

                for (int i=0;i<tenants.size();i++){
                    JSONObject tenant = tenants.optJSONObject(i);
                    if (list.contains(tenant.optString("tenantId"))){
                        result.put(tenant.optString("tenantId"), tenant.optString("tenantName"));
                    }
                }
            }
        }
        return result;

    }

    public static String getTenant(String phone) throws IOException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, JSONException {
        String tenantInfo = TenantCenter.getAuthTenantInfo(phone, "ssc_baozhang");
        if (!StringUtils.isEmpty(tenantInfo)) {
            JSONObject info = JSONObject.fromObject(tenantInfo);
            if (info.has("status") && "1".equals(info.getString("status"))){
                JSONArray tenants = info.getJSONArray("tenants");
                if (tenants.size() < 1){
                    return "";
                }else if (tenants.size() == 1){
                    return tenants.optJSONObject(0).optString("tenantId");
                }else {
                    Connection conn = null;
                    Statement stmt = null;

                    Properties props = Resources.getResourceAsProperties("jdbc.properties");
                    String url = props.getProperty("url");
                    String driver = props.getProperty("driver");
                    String username = props.getProperty("username");
                    String password = props.getProperty("password");

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url, username, password);
                    //先建库
                    stmt = conn.createStatement();
                    stmt.execute("show databases");

                    ResultSet rs = stmt.getResultSet();

                    List<String> list = new ArrayList<String>();
                    //我知道这个只用一列,因此直接加载
                    while (rs.next()){
                        list.add(rs.getString(1));
                    }
                    rs.close();
                    stmt.close();
                    conn.close();
                    //有效租户
                    List<String> usableTenant = new ArrayList<String>();
                    for (int i=0;i<tenants.size();i++){
                        JSONObject tenant = tenants.optJSONObject(i);
                        if (list.contains(tenant.optString("tenantId"))){
                            usableTenant.add(tenant.optString("tenantId"));
                        }
                    }
                    for(String tenant:usableTenant) {
                        if (usableTenant.size() > 1 && "xx9i3hpm".equals(tenant)) {
                            continue;
                        }
                        return tenant;
                    }
                }
            }else {
                return "";
            }

        }

        return "";
    }

    public static void ininTenantDB(String tenant) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        Connection conn = null;
        Statement stmt = null;
        try{
//            Properties props = Resources.getResourceAsProperties("jdbc.properties");
            //链接信息
            Properties props = Resources.getResourceAsProperties("jdbc.properties");
            String url = props.getProperty("url");
            String driver = props.getProperty("driver");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
            //先建库
            stmt = conn.createStatement();
            //CREATE DATABASE db_name DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
            stmt.execute("create database " + tenant + " DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci");

            //切换到新建租户
            conn.setCatalog(tenant);
            //导入表结构
            ScriptRunner runner = new ScriptRunner(conn);

            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);

//            runner.runScript(Resources.getResourceAsReader("test.sql"));
            Resources.setCharset(Charset.forName("utf-8"));
            runner.runScript(Resources.getResourceAsReader("MyProject.sql"));
            //add by congdy 2017.3.17 添加工作台的sql
            String menu = FileUtils.readFileToString(Resources.getResourceAsFile("workbench/workbench.sql"), String.valueOf(Charset.forName("utf-8")));
            String workbench = menu.replaceAll("q4v4r2ki", tenant);
            runner.runScript(new StringReader(workbench));
            //runner.runScript(Resources.getResourceAsReader("workbench/workbench.sql"));
        }catch(Exception e) {
            logger.error("tenant init error,e=", E2S.exception2String(e));
        }finally{
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("tenant init conn release error,e=", E2S.exception2String(e));
            }
        }
    }

    public static void initERPDB(String tenant, String erpMenusPath, String erpFuncsPath) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        Connection conn = null;
        Statement stmt = null;
        try{
            //链接信息
            Properties props = Resources.getResourceAsProperties("jdbc.properties");
            String url = props.getProperty("url");
            String driver = props.getProperty("driver");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
            //切换到新建租户
            conn.setCatalog(tenant);
            //导入表结构
            ScriptRunner runner = new ScriptRunner(conn);

            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);

//            runner.runScript(Resources.getResourceAsReader("test.sql"));
            Resources.setCharset(Charset.forName("utf-8"));
            //执行工作台初始化库脚本

            String menu = FileUtils.readFileToString(Resources.getResourceAsFile(erpMenusPath), String.valueOf(Charset.forName("utf-8")));
            String erpMenuSQL = menu.replaceAll("q4v4r2ki", tenant);
            Reader reader = new StringReader(erpMenuSQL);
            runner.runScript(reader);

            String funcs = FileUtils.readFileToString(Resources.getResourceAsFile(erpFuncsPath), String.valueOf(Charset.forName("utf-8")));
            String erpFuncsSQL = funcs.replaceAll("q4v4r2ki", tenant);
            runner.runScript((new StringReader(erpFuncsSQL)));
            //runner.runScript(Resources.getResourceAsReader(erpFuncsPath));
        }catch(Exception e) {
            logger.error("tenant init error,e=", E2S.exception2String(e));
        }finally{
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("tenant init conn release error,e=", E2S.exception2String(e));
            }
        }
    }
}
