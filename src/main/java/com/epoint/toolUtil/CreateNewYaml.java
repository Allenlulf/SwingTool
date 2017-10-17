package com.epoint.toolUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.ho.yaml.Yaml;

import com.epoint.action.ZtbBean;

public class CreateNewYaml
{
    public void createyaml(String yamlFilepath, String value) {
        try {
            ZtbBean ztbBean = new ZtbBean();
            ztbBean.setServertype("tomcat");
            ztbBean.setVirtualname(value);
            ZtbBean[] configlist = null;
            Map<String, String> map1 = new HashMap<String, String>();
            Map<String, String> map2 = new HashMap<String, String>();
            Map<String, String> map3 = new HashMap<String, String>();
            Map<String, String> map4 = new HashMap<String, String>();
            Map<String, String> map5 = new HashMap<String, String>();
            Map<String, String> map6 = new HashMap<String, String>();
            // 根据不同的项目来创建不同的yaml模板
            if ("EpointWebService".equals(value)) {
                configlist = new ZtbBean[1];
                configlist[0] = new ZtbBean();
                configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                map1 = new HashMap<String, String>();
                map1.put("dialect", null);
                map1.put("driverclass", null);
                map1.put("urlAddr", null);
                map1.put("username", null);
                map1.put("password", null);
                configlist[0].setParams(map1);
            }
            else {
                if ("TPPingBiao".equals(value)) {
                    configlist = new ZtbBean[5];
                    configlist[0] = new ZtbBean();
                    configlist[1] = new ZtbBean();
                    configlist[2] = new ZtbBean();
                    configlist[3] = new ZtbBean();
                    configlist[4] = new ZtbBean();
                    configlist[0].setFilepath("WEB-INF/classes/jdbc.properties");
                    configlist[1].setFilepath("fui/js/lib/ewebeditor/jsp/config.jsp");
                    configlist[2].setFilepath("WEB-INF/classes/ztb.properties");
                    configlist[3].setFilepath("WEB-INF/web.xml");
                    configlist[4].setFilepath("WEB-INF/classes/epointframe.properties");
                    map1.put("urlAddr", null);
                    map1.put("username", null);
                    map1.put("password", null);
                    map2.put("License", null);
                    map3.put("ZTBFileStorageType", null);
                    map3.put("ZTBFileStoragePath", null);
                    map3.put("EpointMisTempFileType", null);
                    map3.put("EpointMisTempPath", null);
                    map3.put("DotNetResutFulUrl", null);
                    map3.put("url_yw", null);
                    map3.put("user_yw", null);
                    map3.put("password_yw", null);
                    map3.put("CloudSignatureURL", null);
                    map3.put("TimeStampSvrUrl", null);
                    map3.put("WebReferencePath", null);
                    map4.put("CustEnable1", null);
                    map4.put("CustEnable2", null);
                    map5.put("redisSetting", null);
                    configlist[0].setParams(map1);
                    configlist[1].setParams(map2);
                    configlist[2].setParams(map3);
                    configlist[3].setParams(map4);
                    configlist[4].setParams(map5);
                }
                else {
                    if ("TPBidder".equals(value)) {
                        configlist = new ZtbBean[6];
                        configlist[0] = new ZtbBean();
                        configlist[1] = new ZtbBean();
                        configlist[2] = new ZtbBean();
                        configlist[3] = new ZtbBean();
                        configlist[4] = new ZtbBean();
                        configlist[5] = new ZtbBean();
                        configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                        configlist[1].setFilepath("WEB-INF/classes/epointframe.properties");
                        configlist[2].setFilepath("WEB-INF/classes/ztb.properties");
                        configlist[3].setFilepath("fui/js/lib/ewebeditor/jsp/config.jsp");
                        configlist[4].setFilepath("WEB-INF/web.xml");
                        configlist[5].setFilepath("WEB-INF/classes/quartz_data.xml");
                        map1.put("dialect", null);
                        map1.put("driverclass", null);
                        map1.put("urlAddr", null);
                        map1.put("username", null);
                        map1.put("password", null);
                        map2.put("redisSetting", null);
                        map2.put("extendRedisChannel", null);
                        map3.put("ZTBFileStorageType", null);
                        map3.put("ZTBFileStoragePath", null);
                        map3.put("EpointMisTempFileType", null);
                        map3.put("EpointMisTempFilePath", null);
                        map3.put("Bid_EncryXMLPath", null);
                        map3.put("JingJiaSystemURL", null);
                        map3.put("JingJiaqueueName", null);
                        map3.put("JingJiaroutingKey", null);
                        map3.put("DotNetResutFulUrl", null);
                        map3.put("Bid_BSTool_Url", null);
                        map3.put("Bid_PingBiao_Url", null);
                        map3.put("Bid_PingBiaoInterface_Url", null);
                        map3.put("CmsWebserviceUrl", null);
                        map3.put("Bid_NetpayNoPrefix", null);
                        map3.put("AttachConnectionStringName", null);
                        map3.put("Bid_IsOpenDataExChange", null);
                        map3.put("GenerateServiceUrl", null);
                        map3.put("UsingRedis", null);
                        map4.put("License", null);
                        map5.put("CustEnable1", null);
                        map5.put("CustEnable2", null);
                        map5.put("WebSocketInitURL", null);
                        map6.put("TaskEnable1", null);
                        map6.put("TaskEnable2", null);
                        configlist[0].setParams(map1);
                        configlist[1].setParams(map2);
                        configlist[2].setParams(map3);
                        configlist[3].setParams(map4);
                        configlist[4].setParams(map5);
                        configlist[5].setParams(map6);
                    }
                    else {
                        configlist = new ZtbBean[5];
                        configlist[0] = new ZtbBean();
                        configlist[1] = new ZtbBean();
                        configlist[2] = new ZtbBean();
                        configlist[3] = new ZtbBean();
                        configlist[4] = new ZtbBean();
                        configlist[0].setFilepath("WEB-INF/classes/META-INF/persistence.xml");
                        configlist[1].setFilepath("WEB-INF/classes/epointframe.properties");
                        configlist[2].setFilepath("WEB-INF/classes/ztb.properties");
                        configlist[3].setFilepath("fui/js/lib/ewebeditor/jsp/config.jsp");
                        configlist[4].setFilepath("WEB-INF/web.xml");
                        map1.put("dialect", null);
                        map1.put("driverclass", null);
                        map1.put("urlAddr", null);
                        map1.put("username", null);
                        map1.put("password", null);
                        map2.put("redisSetting", null);
                        map3.put("ZTBFileStorageType", null);
                        map3.put("ZTBFileStoragePath", null);
                        map3.put("EpointMisTempFileType", null);
                        map3.put("EpointMisTempFilePath", null);
                        map3.put("Bid_EncryXMLPath", null);
                        map3.put("SysType", null);
                        map3.put("JingJiaSystemURL", null);
                        map3.put("DotNetResutFulUrl", null);
                        map3.put("Bid_BSTool_Url", null);
                        map3.put("Bid_PingBiao_Url", null);
                        map3.put("Bid_PingBiaoInterface_Url", null);
                        map3.put("CmsWebserviceUrl", null);
                        map3.put("CacheServices", null);
                        map3.put("AttachConnectionStringName", null);
                        map3.put("Bid_IsOpenDataExChange", null);
                        map3.put("GenerateServiceUrl", null);
                        map3.put("Bid_CreditEvaluation_Url", null);
                        map3.put("IsDebug", null);
                        map4.put("License", null);
                        map5.put("CustEnable1", null);
                        map5.put("CustEnable2", null);
                        configlist[0].setParams(map1);
                        configlist[1].setParams(map2);
                        configlist[2].setParams(map3);
                        configlist[3].setParams(map4);
                        configlist[4].setParams(map5);
                    }
                }
            }
            ztbBean.setConfiglist(configlist);
            File dumpFile = new File(yamlFilepath);
            try {
                Yaml.dump(ztbBean, dumpFile);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            new FileUtil().dofile(yamlFilepath);
        }
        catch (Exception e) {
            e.getStackTrace().toString();
        }
    }
}
