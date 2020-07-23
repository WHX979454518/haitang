package com.mxkj.htmusic.toolmodule.utils.rxbus;

import io.reactivex.observers.DisposableObserver;

/**
 *
 */
public abstract class RxBusSubscriber<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {
        try {
            onEvent(t);
        } catch (Exception e) {
            e.printStackTrace();
            onError(e);
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
    }

    protected abstract void onEvent(T t) throws Exception;

}