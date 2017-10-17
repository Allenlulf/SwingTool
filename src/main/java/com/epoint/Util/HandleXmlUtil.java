package com.epoint.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yaml.snakeyaml.Yaml;

import com.epoint.action.Configuration;

public class HandleXmlUtil
{
    private Yaml yaml = new Yaml();

    public void CreateNewXml(String filepath, String yamlFilepath) {
        try {
            StringBuffer sb = new StringBuffer("");
            FileReader reader = new FileReader(filepath);
            BufferedReader br = new BufferedReader(reader);
            String str = null;
            Configuration config = yaml.loadAs(new FileInputStream(yamlFilepath), Configuration.class);
            while ((str = br.readLine()) != null) {
                if (str.contains(".Env.")) {
                    // 先通过正则来获取要替换的内容
                    String regex = "(?<=\\{)(.+?)(?=\\})";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(str);
                    String value = "";
                    if (m.find()) {
                        value = str.substring(str.lastIndexOf(m.group(1)) - 1,
                                str.lastIndexOf(m.group(1)) + m.group(1).length() + 2);
                    }
                    str = str.replace(value,
                            getStr(config.getConfiglist()
                                    .get(new KeyIndexUtil().getindexbykey(
                                            m.group(1).substring(m.group(1).lastIndexOf(".") + 1).trim()))
                                    .getParams().get(m.group(1).substring(m.group(1).lastIndexOf(".") + 1).trim())));
                }
                sb.append(str + "\r\n");
            }
            br.close();
            reader.close();
            // 剥离template生成相应的配置文件名
            String filename = filepath.substring(filepath.lastIndexOf(File.separator) + 1).substring(0,
                    filepath.substring(filepath.lastIndexOf(File.separator) + 1).length() - 9);
            // 保存属性到properties文件
            String Pathdir = yamlFilepath.substring(0, yamlFilepath.lastIndexOf(File.separator));
            if (filename.equals("web.xml")) {
                // 此路径为web.xml配置路径
                Pathdir = Pathdir.substring(0, Pathdir.lastIndexOf("resources")) + "webapp" + File.separator
                        + "WEB-INF";
            }
            else if (filename.equals("persistence.xml")) {
                Pathdir = Pathdir.substring(0, Pathdir.lastIndexOf(File.separator)) + File.separator + "META-INF";
            }
            else if (filename.equals("config.jsp")) {
                // 此路径为config.jsp配置路径
                Pathdir = Pathdir.substring(0, Pathdir.lastIndexOf("resources")) + "webapp" + File.separator + "fui"
                        + File.separator + "js" + File.separator + "lib" + File.separator + "ewebeditor"
                        + File.separator + "jsp";
            }
            else {
                // 此路径是resources下的路径
                Pathdir = Pathdir.substring(0, Pathdir.lastIndexOf(File.separator));
            }
            if (!new File(Pathdir).isDirectory()) {
                new File(Pathdir).mkdirs();
            }
            Pathdir = Pathdir + File.separator + filename;
            if (new File(Pathdir).exists()) {
                new File(Pathdir).delete();
            }
            FileWriter writer = new FileWriter(Pathdir);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(sb.toString());
            bw.close();
            writer.close();
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
