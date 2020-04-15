package com.example.androidlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.example.androidlearningapp.adapters.TimesTableAdapter;
import com.example.androidlearningapp.model.TimeTable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TimeTable> timeTables;
    protected TimesTableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar simpleSeekBar = (SeekBar) findViewById(R.id.seekBar);
        simpleSeekBar.setMax(9);
        simpleSeekBar.setOnSeekBarChangeListener(new TableSeekBarListener());
        initRecyclerView();
    }

    private void initRecyclerView() {
        timeTables = TimeTable.createTimeTableList(1);
        adapter = new TimesTableAdapter(this, timeTables);
        RecyclerView recyclerView = findViewById(R.id.recyclerTableView);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private class TableSeekBarListener implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            adapter.clear();
            adapter.addAll(TimeTable.createTimeTableList(progress+1));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    }


}
