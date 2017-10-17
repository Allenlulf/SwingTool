package com.epoint.toolUtil;

public class ComboxItem
{
    public ComboxItem(String key,String Name){
        this.key = key;
        this.Name = Name;
    }
    private String key;
    private String Name;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    
    public String toString(){
        return Name;
    }
}
