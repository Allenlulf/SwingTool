package com.epoint.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{

    private static List<String> list = new ArrayList<String>();

    private static int i = 0;

    // 递归遍历
    public void getDirectory(File file, String yamlpath) {
        File flist[] = file.listFiles();
        if (flist == null || flist.length == 0) {
            return;
        }
        for (File f : flist) {
            if (f.isDirectory()) {
                // 这里将列出所有的文件夹
                System.out.println("Dir==>" + f.getAbsolutePath());
                getDirectory(f, yamlpath);
            }
            else {
                // 这里将列出所有的文件
                String FileName = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf(File.separator) + 1);
                if (FileName.contains("xml") || FileName.contains("properties")) {
                    new HandleXmlUtil().CreateNewXml(f.getAbsolutePath(), yamlpath);
                }
            }
        }
    }

    public List<String> getYamlList(File file) {
        int i = 0;

        File flist[] = file.listFiles();
        if (flist == null || flist.length == 0) {
            return list;
        }
        for (File f : flist) {
            if (f.isDirectory()) {
                // 这里将列出所有的文件夹
                getYamlList(f);
            }
            else {
                if (f.getAbsolutePath().endsWith("yaml")) {
                    list.add(i, f.getAbsolutePath());
                    i++;
                }
            }
        }
        return list;
    }

    // 递归遍历过滤出涵盖有Template目录的project
    public List<String> getFileNameList(String path) {
        File file = new File(path);
        File[] flist = file.listFiles();
        if (flist == null || flist.length == 0) {
            return null;
        }
        for (File f : flist) {
            String filepath = f.getAbsolutePath();
            if (f.isDirectory()) {
                String tmp = filepath + "/src/main/resources/Docker/Template";
                if (new File(tmp).exists()) {// 表示有模板
                    list.add(i, filepath.substring(filepath.lastIndexOf(File.separator) + 1));
                }
            }
        }
        return list;
    }

    public List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        FileUtil.list = list;
    }

}
