package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 *
 */

public class SearchRecommendEvent {

    public SearchRecommendEvent(int id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * id : 3578
     * title : 爱你一万年
     */
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
