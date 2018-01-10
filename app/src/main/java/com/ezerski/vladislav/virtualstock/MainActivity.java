package com.ezerski.vladislav.virtualstock;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.services.Uploader;
import com.ezerski.vladislav.virtualstock.services.adapters.ArrayImageAdapter;
import com.ezerski.vladislav.virtualstock.services.impl.MapUpploader;

import java.util.Random;

import static com.ezerski.vladislav.virtualstock.services.storage.MapStorage.HORIZONTAL_SIZE;

public class MainActivity extends AppCompatActivity {

    protected ArrayAdapter<Image> adapter;
    protected GridView gridView;
    protected RobotsMoving robot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_settings = findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        Button btn_start = findViewById(R.id.btn_start);
        gridView = findViewById(R.id.grid_view);
        adapter = new ArrayImageAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_single_choice);
        robot = new RobotsMoving(gridView);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploader uploader = new MapUpploader();
                uploader.upload(getApplicationContext());

                adapter.notifyDataSetInvalidated();
                gridView.setNumColumns(HORIZONTAL_SIZE);
                gridView.post(new Runnable() {
                    @Override
                    public void run() {
                        gridView.setAdapter(adapter);
                    }
                });
                new Thread(new MyThread(),"MyThread").start();
            }
        });
    }
}