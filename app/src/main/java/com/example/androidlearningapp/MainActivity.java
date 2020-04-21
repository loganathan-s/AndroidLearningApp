package com.example.androidlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.logging.SocketHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.androidlearningapp", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("testString", "TEST").apply();
        Log.i("SharedPreferences", sharedPreferences.getString("testString", ""));
    }
}
