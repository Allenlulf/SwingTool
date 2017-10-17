package com.epoint.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.epoint.swingUtil.MainFrame;
import com.epoint.toolUtil.InsertData;

/**
 * 负责处理与yaml实体类交互的工具类
 * 
 * @作者 lulf
 * @version [版本号, 2017年9月13日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConfigurationUtil
{
    private Yaml yaml = new Yaml();
    private static Configuration configuration = null;
    private static int hashcode = 0;
    private String yamlFilepath = "";

    @SuppressWarnings("static-access")
    public ConfigurationUtil(String yamlFilepath) throws FileNotFoundException {
        Configuration config = yaml.loadAs(new FileInputStream(yamlFilepath), Configuration.class);
        this.configuration = config;
    }

    public ConfigurationUtil() {
        yamlFilepath = MainFrame.getYamlPath();
        try {
            configuration = yaml.loadAs(new FileInputStream(yamlFilepath), Configuration.class);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        hashcode = yamlFilepath.hashCode();
    }

    /**
     * 根据枚举和yaml文件路径获取相应的map
     * 
     * @param yamlFilepath
     * @param i
     * @return
     */
    public Map<String, String> getMap(String yamlFilepath, String name) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            if (MainFrame.getYamlPath().hashCode() != hashcode) {
                configuration = yaml.loadAs(new FileInputStream(yamlFilepath), Configuration.class);
                hashcode = MainFrame.getYamlPath().hashCode();
            }
            for (int j = 0; j < configuration.getConfiglist().size(); j++) {
                if (configuration.getConfiglist().get(j).getFilepath().contains(name)) {
                    if ("ztb.properties".equals(name))
                        configuration.getConfiglist().get(j).getParams();
                    return configuration.getConfiglist().get(j).getParams();
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e1) {
            e1.printStackTrace();
        }
        return map;
    }

    public String getSQLConFileName(String yamlFilepath) {
        try {
            if (MainFrame.getYamlPath().hashCode() != hashcode) {
                configuration = yaml.loadAs(new FileInputStream(yamlFilepath), Configuration.class);
                hashcode = MainFrame.getYamlPath().hashCode();
            }
            return configuration.getConfiglist().get(0).getFilepath();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        return "";
    }

    @SuppressWarnings("static-access")
    public void save(String yamlfilepath, MainFrame mainFrame) {
        try {
            String value=mainFrame.getNameConfigure().getBox1Text();
            ZtbBean ztbBean = new ZtbBean();
            ztbBean.setServertype("tomcat");
            ztbBean.setVirtualname(value);
            ZtbBean[] configlist = null;
            if("EpointWebService".equals(value)){
                configlist = new ZtbBean[1];
                configlist[0] = new ZtbBean();
                if ("jdbc.properties".equals(mainFrame.getSQLCfgFileName()))
                    configlist[0].setFilepath("WEB-INF/classes/jdbc.properties");
                else {
                    configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                }
                configlist[0].setParams(configuration.getConfiglist().get(0).getParams());
            }else{
                if ("TPPingBiao".equals(value)) {
                    configlist = new ZtbBean[5];
                    configlist[0] = new ZtbBean();
                    configlist[1] = new ZtbBean();
                    configlist[2] = new ZtbBean();
                    configlist[3] = new ZtbBean();
                    configlist[4] = new ZtbBean();
                    if ("jdbc.properties".equals(mainFrame.getSQLCfgFileName()))
                        configlist[0].setFilepath("WEB-INF/classes/jdbc.properties");
                    else {
                        configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                    }
                    configlist[1].setFilepath("fui/js/lib/ewebeditor/jsp/config.jsp");
                    configlist[2].setFilepath("WEB-INF/classes/ztb.properties");
                    configlist[3].setFilepath("WEB-INF/web.xml");
                    configlist[4].setFilepath("WEB-INF/classes/epointframe.properties");
                    configlist[0].setParams(configuration.getConfiglist().get(0).getParams());
                    configlist[1].setParams(configuration.getConfiglist().get(1).getParams());
                    configlist[2].setParams(configuration.getConfiglist().get(2).getParams());
                    configlist[3].setParams(configuration.getConfiglist().get(3).getParams());
                    configlist[4].setParams(configuration.getConfiglist().get(4).getParams());
                    
                }else{
                    if ("TPBidder".equals(value)) {
                        configlist = new ZtbBean[6];
                        configlist[0] = new ZtbBean();
                        configlist[1] = new ZtbBean();
                        configlist[2] = new ZtbBean();
                        configlist[3] = new ZtbBean();
                        configlist[4] = new ZtbBean();
                        configlist[5] = new ZtbBean();
                        if ("jdbc.properties".equals(mainFrame.getSQLCfgFileName()))
                            configlist[0].setFilepath("WEB-INF/classes/jdbc.properties");
                        else {
                            configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                        }
                        configlist[1].setFilepath("WEB-INF/classes/epointframe.properties");
                        configlist[2].setFilepath("WEB-INF/classes/ztb.properties");
                        configlist[3].setFilepath("fui/js/lib/ewebeditor/jsp/config.jsp");
                        configlist[4].setFilepath("WEB-INF/web.xml");
                        configlist[5].setFilepath("WEB-INF/classes/quartz_data.xml");
                        configlist[0].setParams(configuration.getConfiglist().get(0).getParams());
                        configlist[1].setParams(configuration.getConfiglist().get(1).getParams());
                        configlist[2].setParams(configuration.getConfiglist().get(2).getParams());
                        configlist[3].setParams(configuration.getConfiglist().get(3).getParams());
                        configlist[4].setParams(configuration.getConfiglist().get(4).getParams());
                        configlist[5].setParams(configuration.getConfiglist().get(5).getParams());
                    }else{
                        configlist = new ZtbBean[5];
                        configlist[0] = new ZtbBean();
                        configlist[1] = new ZtbBean();
                        configlist[2] = new ZtbBean();
                        configlist[3] = new ZtbBean();
                        configlist[4] = new ZtbBean();
                        if ("jdbc.properties".equals(mainFrame.getSQLCfgFileName()))
                            configlist[0].setFilepath("WEB-INF/classes/jdbc.properties");
                        else {
                            configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                        }
                        configlist[1].setFilepath("WEB-INF/classes/epointframe.properties");
                        configlist[2].setFilepath("WEB-INF/classes/ztb.properties");
                        configlist[3].setFilepath("fui/js/lib/ewebeditor/jsp/config.jsp");
                        configlist[4].setFilepath("WEB-INF/web.xml");
                        configlist[0].setParams(configuration.getConfiglist().get(0).getParams());
                        configlist[1].setParams(configuration.getConfiglist().get(1).getParams());
                        configlist[2].setParams(configuration.getConfiglist().get(2).getParams());
                        configlist[3].setParams(configuration.getConfiglist().get(3).getParams());
                        configlist[4].setParams(configuration.getConfiglist().get(4).getParams());
                    }
                }
            }
            ztbBean.setConfiglist(configlist);
            new InsertData().Insertfile(ztbBean, yamlfilepath);
        }
        catch (Exception e) {
            e.getStackTrace().toString();
        }
    }
}
