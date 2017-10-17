package com.epoint.toolUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 处理Jyaml生成出来的无序文件
 * 
 * @作者 lulf
 * @version [版本号, 2017年8月14日]
 */
public class FileUtil
{
    @SuppressWarnings({"unchecked", "rawtypes" })
    public void dofile(String filePath) {
        File file = new File(filePath);
        try {
            String removeline = "- !com.epoint.action.ZtbBean";

            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String instring;
            ArrayList<String> al = new ArrayList();
            try {
                while ((instring = br.readLine()) != null) {
                    al.add(instring);// 放入ArrayList从而确定有多少行
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < al.size(); i++) {
                if (i >= al.size() - 2) {
                    sb.append(al.get(i) + "\r");
                }
            }
            for (int i = 1; i < al.size() - 2; i++) {
                if (i == 1) {
                    sb.append("configlist:" + "\r");
                }
                else if (al.get(i).contains(removeline)) {
                    continue;
                }
                else if (al.get(i).contains("filepath")) {
                    if (i > 5) {
                        sb.append("\r");
                        sb.append("- " + al.get(i).trim() + "\r");
                    }
                    else {
                        sb.append("- " + al.get(i).trim() + "\r");
                    }
                }
                else if (al.get(i).contains("params")) {
                    sb.append("  " + al.get(i).trim() + "\r");
                }
                else {
                    sb.append("    " + al.get(i).trim() + "\r");
                }
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write((sb.toString().replaceAll("\"", "")).replaceAll("~", ""));
            bw.close();
        }
        catch (Exception e) {
        }
    }
}
