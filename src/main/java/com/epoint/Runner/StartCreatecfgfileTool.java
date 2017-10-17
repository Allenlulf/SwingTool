package com.epoint.Runner;

import java.io.File;

import com.epoint.Util.FileUtil;

/**
 * 启动bat
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月31日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StartCreatecfgfileTool
{
    public static void main(String[] args) {
        String yamlfilepath = args[0];
        if (yamlfilepath.endsWith(";"))
            yamlfilepath=yamlfilepath.substring(0, yamlfilepath.length() - 1);
        String tempdir = yamlfilepath.substring(0, yamlfilepath.lastIndexOf(File.separator)) + File.separator
                + "Template";
        new FileUtil().getDirectory(new File(tempdir), yamlfilepath);
    }
}
