package com.ezerski.vladislav.virtualstock.services;

import android.content.Context;

/**
 * Created by Vladislav on 06.01.2018.
 */

public interface Uploader {

    void upload(Context context, String path);

    void upload(Context context);
}
