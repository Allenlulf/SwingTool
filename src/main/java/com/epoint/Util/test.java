package com.epoint.Util;

import java.io.File;

public class test
{
    public static void main(String[] args) {
        
       String file="D:"+File.separator+"SubSys_PingBiao";
       System.out.println(new FileUtil().getFileNameList(file));

    }
}
