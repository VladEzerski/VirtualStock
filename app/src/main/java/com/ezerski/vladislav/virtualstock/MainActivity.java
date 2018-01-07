package com.ezerski.vladislav.virtualstock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.services.Uploader;
import com.ezerski.vladislav.virtualstock.services.adapters.ImageAdapter;
import com.ezerski.vladislav.virtualstock.services.impl.MapUpploader;

public class MainActivity extends AppCompatActivity {

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
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploader uploader = new MapUpploader();
                uploader.upload(getApplicationContext());

                GridView gridView = findViewById(R.id.grid_view);
                ImageAdapter adapter = new ImageAdapter(getApplicationContext());
                gridView.invalidateViews();
                gridView.setAdapter(adapter);
                adapter.rewrite();
            }
        });
    }
}