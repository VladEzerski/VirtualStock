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
import com.ezerski.vladislav.virtualstock.adapters.ArrayImageAdapter;
import com.ezerski.vladislav.virtualstock.services.impl.CustomRobotsMovingTimer;
import com.ezerski.vladislav.virtualstock.services.impl.MapUpploader;
import com.ezerski.vladislav.virtualstock.services.impl.RobotsMover;

import java.util.Timer;
import java.util.TimerTask;

import static com.ezerski.vladislav.virtualstock.storage.MapStorage.HORIZONTAL_SIZE;

public class MainActivity extends AppCompatActivity {

    protected ArrayAdapter<Image> adapter;
    protected GridView gridView;
    protected RobotsMover robot;
    protected Timer timer;

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
        robot = new RobotsMover(gridView);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploader uploader = new MapUpploader();
                uploader.upload(getApplicationContext());

                adapter.notifyDataSetInvalidated();
                gridView.setNumColumns(HORIZONTAL_SIZE);
                gridView.setAdapter(adapter);
                timer = new Timer();
                timer.scheduleAtFixedRate(new CustomRobotsMovingTimer(gridView, MainActivity.this), 0, 1000);

            }
        });
    }
}