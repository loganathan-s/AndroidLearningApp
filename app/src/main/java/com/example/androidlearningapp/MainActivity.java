package com.example.androidlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView animalList = findViewById(R.id.animal);
        final ArrayList<String> animals = new ArrayList<String>(asList("Tiger", "Lion", "Horse", "Zebra", "Fox", "Camel"));
        ArrayAdapter<String> animalAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animals);
        animalList.setAdapter(animalAdapter);

        animalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                android.widget.Toast.makeText(getApplicationContext(), animals.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
