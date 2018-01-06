package com.ezerski.vladislav.virtualstock.services.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.ezerski.vladislav.virtualstock.dto.InputMapProperties;
import com.ezerski.vladislav.virtualstock.services.MapStorage;
import com.ezerski.vladislav.virtualstock.services.Uploader;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.ezerski.vladislav.virtualstock.utils.Constants.MAP_PATH;

/**
 * Created by Vladislav on 06.01.2018.
 */

public class MapUpploader implements Uploader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JsonFactory jfactory = new JsonFactory();

    @Override
    public void upload(Context context, String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void upload(Context context) {

        try {
            JsonParser jParser = jfactory.createParser(
                    context.getResources().openRawResource(
                            context.getResources().getIdentifier(MAP_PATH,
                                    "raw", context.getPackageName())));

            InputMapProperties inputMapProperties = objectMapper.readValue(jParser, InputMapProperties.class);
            MapStorage.HORIZONTAL_SIZE = inputMapProperties.getHorizontalSize();
            MapStorage.VERTICAL_SIZE = inputMapProperties.getVerticalSize();
            MapStorage.MAP = inputMapProperties.getMap();

        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path " + MAP_PATH);
        }
    }
}
