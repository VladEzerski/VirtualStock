package com.ezerski.vladislav.virtualstock.services;

import android.content.Context;

public interface Uploader {

    void upload(Context context, String path);

    void upload(Context context);
}
