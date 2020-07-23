package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 *
 */

public class MusicIanEvent {

    public MusicIanEvent(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
