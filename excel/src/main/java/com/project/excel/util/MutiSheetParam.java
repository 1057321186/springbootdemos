package com.project.excel.util;

import java.util.List;

/**
 * @author tct
 * @desc
 * @create in  2020/11/5
 **/
public class MutiSheetParam {

    /**
     * sheet name
     */
    private String key;

    /**
     * value
     */
    private List<?> list;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
