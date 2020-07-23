package com.mxkj.htmusic.toolmodule.utils.rxbus.event;

/**
 */
public class RequestStorageReadAccessPermissionEvent {

    private boolean success;

    public RequestStorageReadAccessPermissionEvent(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

}
