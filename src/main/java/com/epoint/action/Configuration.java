package com.epoint.action;

import java.util.List;

/**
 * 最外层
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月14日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Configuration
{
    private String servertype;
    private String virtualname;
    private List<Configurainaction> configlist;
    private Configurainaction configurainaction;

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

    public List<Configurainaction> getConfiglist() {
        return configlist;
    }

    public void setConfiglist(List<Configurainaction> configlist) {
        this.configlist = configlist;
    }

    public Configurainaction getConfigurainaction() {
        return configurainaction;
    }

    public void setConfigurainaction(Configurainaction configurainaction) {
        this.configurainaction = configurainaction;
    }
}
