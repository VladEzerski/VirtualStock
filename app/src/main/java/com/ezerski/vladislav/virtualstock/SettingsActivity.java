package com.ezerski.vladislav.virtualstock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ezerski.vladislav.virtualstock.storage.MapStorage;

public class SettingsActivity extends AppCompatActivity {

    public int robotCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                Intent intent = new Intent();
                switch (checkedID){
                    case -1:
                        Toast.makeText(getApplicationContext(),"Nothing selected",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad_btn_two_robots:
                        intent.putExtra("robotCount", MapStorage.ROBOT_COUNT = 2);
                        break;
                    case R.id.rad_btn_three_robots:
                        intent.putExtra("robotCount", MapStorage.ROBOT_COUNT = 3);
                        break;
                    case R.id.rad_btn_four_robots:
                        intent.putExtra("robotCount", MapStorage.ROBOT_COUNT = 4);
                        break;
                    case R.id.rad_btn_five_robots:
                        intent.putExtra("robotCount", MapStorage.ROBOT_COUNT = 5);
                        break;
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
