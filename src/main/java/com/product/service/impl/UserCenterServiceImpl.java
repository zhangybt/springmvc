package com.product.service.impl;

import com.product.dao.NcInfoMapper;
import com.product.dao.UserMapper;
import com.product.entity.Person;
import com.product.entity.User;
import com.product.service.IUserCenterService;
import com.product.utils.StringUtil;
import com.product.utils.TenantInitUtil;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.tenant.sdk.UserCenter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangybt on 2017/5/22.
 */
@Service
public class UserCenterServiceImpl implements IUserCenterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NcInfoMapper ncInfoMapper;

    private final static Logger logger = LoggerFactory.getLogger(UserCenterServiceImpl.class);

    public List<Person> selectRelation(String adminPhone) {

        try {
//            String[] adminPhoneCollection = adminPhone.split(",");
//            List<Person> mapList = new ArrayList<Person>();
//            Person person = new Person();
//            int k = 1;
//            for (int i = 0; i < adminPhoneCollection.length; i++) {
//                String phone = adminPhoneCollection[i];
//                JSONObject userLoginInfo = JSONObject.fromObject(UserCenter.getUserByLoginName(phone));
//                JSONObject userInfo = JSONObject.fromObject(userLoginInfo.get("user"));
//                if (userInfo.size() == 0) {
//                    continue;
//                }
//                String centerUserId = userInfo.get("userId").toString();
//                String tenantUserRelations = UserCenter.getTenantUserRelations(centerUserId);
//                if (StringUtil.isEmpty(tenantUserRelations)) {
//                    continue;
//                }
//                JSONObject jsonObject = JSONObject.fromObject(tenantUserRelations);
//                String relations = jsonObject.get("relations").toString();
//                JSONArray jsonArray = JSONArray.fromObject(relations);
//                for (int j = 0; j < jsonArray.size(); j++) { //JSONObject.fromObject(jsonArray.get(i)).get("typeId").equals(3)
//                    JSONObject relationsList = JSONObject.fromObject(jsonArray.get(j));
//                    boolean result = TenantInitUtil.checkTenantDatabase(relationsList.get("tenantId").toString());
//                    if (!result) {
//                        person = this.selectPerson(phone, centerUserId, relationsList.get("tenantId").toString(), "非友报账租户");
//                        mapList.add(person);
//                        System.out.println("不属于有报账租户的有" + relationsList.get("tenantId") + "  " + k++);
//                        continue;
//                    }
//                    String typeId = relationsList.get("typeId").toString();
//                    if (typeId.equals("1")) {
//                        InvocationInfoProxy.setTenantid(relationsList.get("tenantId").toString());
//                        User user = userMapper.selectByPhone(phone);
//                        if (user != null) {
//                            if ("nc".equals(ncInfoMapper.selectOsType())) {
//                                person = this.selectPerson(phone, centerUserId, relationsList.get("tenantId").toString(), "NC租户");
//                                mapList.add(person);
//                                System.out.println("NC租户的信息：" + phone + " " + relationsList.get("tenantId"));
//                            } else if ("u8".equals(ncInfoMapper.selectOsType())) {
//                                person = this.selectPerson(phone, centerUserId, relationsList.get("tenantId").toString(), "U8租户");
//                                mapList.add(person);
//                                System.out.println("U8租户的信息：" + " " + phone + " " + relationsList.get("tenantId"));
//                            } else {
//                                person = this.selectPerson(phone, centerUserId, relationsList.get("tenantId").toString(), "其它租户");
//                                mapList.add(person);
//                                System.out.println("不是U8也不是NC租户的信息：" + " " + phone + " " + relationsList.get("tenantId"));
//                            }
//                        }
//                    } else {
//                        User user = userMapper.selectByPhone(phone);
//                        if (user != null) {
//                            person = this.selectPerson(phone, centerUserId, relationsList.get("tenantId").toString(), "本地存在的用户");
//                            mapList.add(person);
//                            System.out.println("本地存在且此号是用户的信息：" + "  " + phone + " " + relationsList.get("tenantId"));
//                        } else {
//                            person = this.selectPerson(phone, centerUserId, relationsList.get("tenantId").toString(), "本地不存在的用户");
//                            mapList.add(person);
//                            System.out.println("本地不存在且此号是用户的信息：" + "  " + phone + "  " + relationsList.get("tenantId"));
//                        }
//                        continue;
//                    }
//                }
//            }
//            System.out.println(mapList);
//            return mapList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> selectUsers() {
        return this.userMapper.selectUsers();
    }

    /**
     * 封装人员信息
     * @param phone
     * @param centerUserId
     * @param tenantId
     * @param msg
     * @return
     */
    public Person selectPerson(String phone, String centerUserId, String tenantId, String msg) {
        Person person = new Person();
        person.setPhone(phone);
        person.setCenterUserId(centerUserId);
        person.setTenanid(tenantId);
        person.setMsg(msg);
        return person;
    }

}
