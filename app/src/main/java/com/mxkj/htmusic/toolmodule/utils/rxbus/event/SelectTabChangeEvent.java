package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 *
 */

public class SelectTabChangeEvent {

    private int tab;//101,附近的人跳转

    public SelectTabChangeEvent(int tab) {
        this.tab = tab;
    }

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
}
