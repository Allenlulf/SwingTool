# SwingTool
用来修改特定yaml文件及根据template模板目录下文件自动生成配置文件的Swing工具
此用具用来解析特定yaml文件
如下：
servertype: tomcat
virtualname: TPPingBiao
configlist:
- filepath: WEB-INF/classes/jdbc.properties
  params:
    urlAddr: jdbc:oracle:thin:@a:a
    password: a
    username: a

- filepath: fui/js/lib/ewebeditor/jsp/config.jsp
  params:
    License: a

- filepath: WEB-INF/classes/ztb.properties
  params:
    EpointMisTempFileType: a
    DotNetResutFulUrl: a
    TimeStampSvrUrl: a
    ZTBFileStoragePath: a
    CloudSignatureURL: a
    user_yw: a
    WebReferencePath: a
    password_yw: a
    ZTBFileStorageType: NFS
    EpointMisTempPath: a
    url_yw: a

- filepath: WEB-INF/web.xml
  params:
    CustEnable1: <!--
    CustEnable2: -->

- filepath: WEB-INF/classes/epointframe.properties
  params:
    redisSetting: 
