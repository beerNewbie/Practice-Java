package com.hbc.bean2;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Beer
 * @Date: 2019/8/9 20:49
 * @Description:
 */

public class Bean1 {
    private String strValue;
    private int intValue;
    private String[] arrayValue;
    private List listValue;
    private Map mapValue;
    private Set setValue;

    public Bean1() {
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String[] getArrayValue() {
        return arrayValue;
    }

    public void setArrayValue(String[] arrayValue) {
        this.arrayValue = arrayValue;
    }

    public List getListValue() {
        return listValue;
    }

    public void setListValue(List listValue) {
        this.listValue = listValue;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    public Set getSetValue() {
        return setValue;
    }

    public void setSetValue(Set setValue) {
        this.setValue = setValue;
    }
}
