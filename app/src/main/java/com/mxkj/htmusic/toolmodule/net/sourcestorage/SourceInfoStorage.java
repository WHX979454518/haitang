package com.mxkj.htmusic.toolmodule.net.sourcestorage;


import com.mxkj.htmusic.toolmodule.net.http.SourceInfo;

/**
 * Storage for {@link SourceInfo}.
 *
 * @author Alexey Danilov (danikula@gmail.com).
 */
public interface SourceInfoStorage {

    SourceInfo get(String url);

    void put(String url, SourceInfo sourceInfo);

    void release();
}
