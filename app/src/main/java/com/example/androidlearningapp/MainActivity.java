package com.example.androidlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertToEuro(View view) {
        EditText dollar = (EditText) findViewById(R.id.editText);
        Double euro = Double.valueOf(String.valueOf(dollar.getText())) * 0.92;
        dollar.setText("");
        Toast.makeText(this, String.format("%.2f", euro)+"€",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
