package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 *
 */

public class RefreshSongListEvent {
    private String type;

    public RefreshSongListEvent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
