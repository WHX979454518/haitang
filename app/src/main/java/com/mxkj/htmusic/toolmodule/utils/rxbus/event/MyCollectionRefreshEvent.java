package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 *
 */

public class MyCollectionRefreshEvent {
    private Boolean isAllSelect;
    private int code;

    public MyCollectionRefreshEvent(Boolean isAllSelect, int code) {
        this.isAllSelect = isAllSelect;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getAllSelect() {
        return isAllSelect;
    }

    public void setAllSelect(Boolean allSelect) {
        isAllSelect = allSelect;
    }
}
