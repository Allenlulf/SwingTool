package com.epoint.action;

import java.util.Map;

public class Configurainaction
{
    private String filepath;
    private Map<String, String> params;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
