package com.epoint.action;

import java.util.Map;

public class ZtbBean
{
    private String servertype;
    private String virtualname;
    private ZtbBean[] configlist;
    private String filepath;
    private Map<String, String> params;

    public String getServertype() {
        return servertype;
    }

    public void setServertype(String servertype) {
        this.servertype = servertype;
    }

    public String getVirtualname() {
        return virtualname;
    }

    public void setVirtualname(String virtualname) {
        this.virtualname = virtualname;
    }

    public ZtbBean[] getConfiglist() {
        return configlist;
    }

    public void setConfiglist(ZtbBean[] configlist) {
        this.configlist = configlist;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}