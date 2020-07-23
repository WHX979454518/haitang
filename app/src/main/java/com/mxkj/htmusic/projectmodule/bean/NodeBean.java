package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;

public class NodeBean implements Serializable {
    private String percentage;
    private String name;

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
