package com.epoint.toolUtil;

import java.io.File;
import java.io.FileNotFoundException;

import org.ho.yaml.Yaml;

import com.epoint.action.ZtbBean;

public class InsertData
{

    public void Insertfile(ZtbBean ztbBean,String yamlFilepath) {
        File dumpFile = new File(yamlFilepath);
        try {
            Yaml.dump(ztbBean, dumpFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        new FileUtil().dofile(yamlFilepath);
    }
}
