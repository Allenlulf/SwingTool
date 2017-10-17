package com.epoint.Util;

/**
 * 根据env的key来定位到是yaml的第几个index
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KeyIndexUtil
{
    public int getindexbykey(String value) {
        String str1 = "urlAddr,username,password";
        String str2 = "License";
        String str3 = "ZTBFileStorageType,ZTBFileStoragePath,EpointMisTempFileType,EpointMisTempPath,DotNetResutFulUrl,url_yw,user_yw,password_yw,CloudSignatureURL,TimeStampSvrUrl,WebReferencePath";
        String str4 = "CustEnable1,CustEnable2";
        String str5 = "redisSetting";
        if (str1.contains(value)) {
            return 0;
        }
        if (str2.contains(value)) {
            return 1;
        }
        if (str3.contains(value)) {
            return 2;
        }
        if (str4.contains(value)) {
            return 3;
        }
        if (str5.contains(value)) {
            return 4;
        }
        return 0;
    }
}
