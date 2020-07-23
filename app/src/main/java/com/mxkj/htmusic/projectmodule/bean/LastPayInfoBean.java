package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;

public class LastPayInfoBean implements Serializable {
    /**
     * type : 1
     * desc : 微信
     * is_last : 0
     */

    private int type;
    private String desc;
    private int is_last;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIs_last() {
        return is_last;
    }

    public void setIs_last(int is_last) {
        this.is_last = is_last;
    }
}