package com.ali.mindvalley.interfaces;

import com.ali.mindvalley.models.MDownloadDataType;


public interface IMProvider {
    public void markAsDone(MDownloadDataType mDownloadDataType);
    public void onFailure(MDownloadDataType mDownloadDataType);
    public void markAsCancel(MDownloadDataType mDownloadDataType);
}
