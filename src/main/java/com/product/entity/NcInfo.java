package com.product.entity;

import java.util.Date;

public class NcInfo {
    private Integer id;

    private String pk;

    private String userid;

    private String ip;

    private String port;

    private String ds;

    private String tokenseed;

    private String version;

    private String maip;

    private String maport;

    private Date ts;

    private String ostype;

    private String osparam;

    private String bpmtenantid;

    private String bpmtenantpid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk == null ? null : pk.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds == null ? null : ds.trim();
    }

    public String getTokenseed() {
        return tokenseed;
    }

    public void setTokenseed(String tokenseed) {
        this.tokenseed = tokenseed == null ? null : tokenseed.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getMaip() {
        return maip;
    }

    public void setMaip(String maip) {
        this.maip = maip == null ? null : maip.trim();
    }

    public String getMaport() {
        return maport;
    }

    public void setMaport(String maport) {
        this.maport = maport == null ? null : maport.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getOstype() {
        return ostype;
    }

    public void setOstype(String ostype) {
        this.ostype = ostype == null ? null : ostype.trim();
    }

    public String getOsparam() {
        return osparam;
    }

    public void setOsparam(String osparam) {
        this.osparam = osparam == null ? null : osparam.trim();
    }

    public String getBpmtenantid() {
        return bpmtenantid;
    }

    public void setBpmtenantid(String bpmtenantid) {
        this.bpmtenantid = bpmtenantid == null ? null : bpmtenantid.trim();
    }

    public String getBpmtenantpid() {
        return bpmtenantpid;
    }

    public void setBpmtenantpid(String bpmtenantpid) {
        this.bpmtenantpid = bpmtenantpid == null ? null : bpmtenantpid.trim();
    }
}