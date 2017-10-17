package com.epoint.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yaml.snakeyaml.Yaml;

import com.epoint.action.Configuration;

/**
 * 处理properties文件
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HandlePropertiesUtil
{

    private Yaml yaml = new Yaml();

    public void CreateNewProperties(String filepath, String yamlFilepath) {
        Properties prop = new Properties();
        try {
            // 读取properties类型属性文件
            InputStream in = new BufferedInputStream(new FileInputStream(filepath));
            prop.load(in); /// 加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            Configuration config = yaml.loadAs(new FileInputStream(yamlFilepath), Configuration.class);
            while (it.hasNext()) {
                String key = it.next();
                if (prop.getProperty(key).contains("Env.")) {
                    // 通过正则匹配获取文件名
                    String regex = "(?<=\\{)(.+?)(?=\\})";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(prop.getProperty(key));
                    if (m.find()) {
                        // System.out.println(m.group(1).substring(m.group(1).lastIndexOf(".")
                        // + 1).trim());
                    }
                    // 使用yaml文件中的值去覆盖properties中的值
                    prop.put(key,
                            getStr(config.getConfiglist()
                                    .get(new KeyIndexUtil().getindexbykey(
                                            m.group(1).substring(m.group(1).lastIndexOf(".") + 1).trim()))
                                    .getParams().get(m.group(1).substring(m.group(1).lastIndexOf(".") + 1).trim())));
                }
            }
            in.close();
            // 保存属性到properties文件
            String Pathdir =yamlFilepath.substring(0,yamlFilepath.lastIndexOf(File.separator));
            Pathdir = Pathdir.substring(0,Pathdir.lastIndexOf(File.separator));
            if (!new File(Pathdir).isDirectory()) {
                new File(Pathdir).mkdirs();
            }
            // 剥离template生成相应的配置文件名
            String filename = filepath.substring(filepath.lastIndexOf(File.separator) + 1).substring(0,
                    filepath.substring(filepath.lastIndexOf(File.separator) + 1).length() - 9);
            Pathdir = Pathdir + File.separator + filename;
            if (new File(Pathdir).exists()) {
                new File(Pathdir).delete();
            }
            FileOutputStream oFile = new FileOutputStream(Pathdir, true);// true表示追加打开
            prop.store(oFile, "The New properties file");
            oFile.close();
        }
        catch (Exception e) {
        }
    }

    public String getStr(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
