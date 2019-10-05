package com.lhh.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.save_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putBoolean("married",false);
                editor.putInt("age",28);
                editor.putString("name","Tom");
                editor.apply();
            }
        });
        Button restoryData = findViewById(R.id.restore_data);
        restoryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefe = getSharedPreferences("data",MODE_PRIVATE);
                String name = prefe.getString("name","");
                int age = prefe.getInt("age",0);
                boolean married = prefe.getBoolean("married",false);
                Log.d("MainActivity", "name is "+name);
                Log.d("MainActivity", "age is "+age);
                Log.d("MainActivity", "married is "+married);

            }
        });
    }
}
