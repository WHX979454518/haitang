package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 *
 */

public class RefreshDataEvent {
    private int code;

    public RefreshDataEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
