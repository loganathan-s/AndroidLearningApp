package com.example.androidlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void validateCredentials(View view) {
        EditText name = (EditText) findViewById(R.id.editName);
        EditText password = (EditText) findViewById(R.id.editPassword);
        Log.i("Entered Name is -> ", name.getText().toString());
        Log.i("Entered Password is -> ", password.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
