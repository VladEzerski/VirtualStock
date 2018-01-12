package com.ezerski.vladislav.virtualstock;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.ezerski.vladislav.virtualstock.services.Uploader;
import com.ezerski.vladislav.virtualstock.adapters.ArrayImageAdapter;
import com.ezerski.vladislav.virtualstock.services.impl.CustomRobotsMovingTimer;
import com.ezerski.vladislav.virtualstock.services.impl.MapUpploader;
import com.ezerski.vladislav.virtualstock.services.impl.RobotsMover;
import com.ezerski.vladislav.virtualstock.storage.MapStorage;

import java.util.Timer;
import java.util.TimerTask;

import static com.ezerski.vladislav.virtualstock.storage.MapStorage.HORIZONTAL_SIZE;

public class MainActivity extends AppCompatActivity {

    final static int REQUEST_CODE = 1;

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
                startActivityForResult(intent, REQUEST_CODE);
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
                timer.scheduleAtFixedRate(new CustomRobotsMovingTimer(gridView,
                        MainActivity.this), 0, 1000);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                MapStorage.ROBOT_COUNT = data.getIntExtra("robotCount", MapStorage.ROBOT_COUNT);
            } else {
                Toast.makeText(getApplicationContext(),"Wrong result",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}