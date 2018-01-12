package com.ezerski.vladislav.virtualstock.services.impl;

import android.content.Context;

import com.ezerski.vladislav.virtualstock.dto.InputMapProperties;
import com.ezerski.vladislav.virtualstock.storage.MapStorage;
import com.ezerski.vladislav.virtualstock.services.Uploader;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.ezerski.vladislav.virtualstock.utils.Constants.MAP_PATH;

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
            //todo add converter
            MapStorage.HORIZONTAL_SIZE = inputMapProperties.getHorizontalSize();
            MapStorage.VERTICAL_SIZE = inputMapProperties.getVerticalSize();
            MapStorage.MAP = inputMapProperties.getMap();
            MapStorage.HORIZONTAL_BOARD = inputMapProperties.getHorizontalBoard();
            MapStorage.VERTICAL_BOARD = inputMapProperties.getVerticalBoard();
            MapStorage.BOX = inputMapProperties.getBox();
            MapStorage.ROBOT = inputMapProperties.getRobot();
            MapStorage.SPACE = inputMapProperties.getSpace();
            MapStorage.START = inputMapProperties.getStart();
            MapStorage.EXIT = inputMapProperties.getExit();

        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path " + MAP_PATH);
        }
    }
}
