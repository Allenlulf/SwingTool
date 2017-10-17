package com.epoint.ztbRunner;

import com.epoint.core.utils.classpath.ClassPathUtil;
import com.epoint.swingUtil.MainFrame;

/**
 * 招投标部署包工具启动类
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月10日]
 */
public class StartTool
{
    public static void main(String[] args) {
        String path = "";
        if (args.length > 0) {
            if (args[0].endsWith(";"))
                path = args[0].substring(0, args[0].length() - 1);
            else {
                path = args[0];
            }
        }
        else {
            path = ClassPathUtil.getDeployWarPath();
            // 先对path做一层通用处理
            path = path.substring(0, path.lastIndexOf("通用") - 1);
        }
        try {
            new MainFrame(path);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
