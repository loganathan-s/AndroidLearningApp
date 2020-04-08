package com.example.androidlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void switchImage(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.cutebaby1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
