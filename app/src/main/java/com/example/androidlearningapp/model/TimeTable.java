package com.example.androidlearningapp.model;

import java.util.ArrayList;

public class TimeTable {
    private Integer tableValue;

    public TimeTable(Integer tableValue) {
        this.tableValue = tableValue;
    }

    public Integer getTableValue() {
        return tableValue;
    }

    public void setTableValue(Integer tableValue) {
        this.tableValue = tableValue;
    }

    public static ArrayList<TimeTable> createTimeTableList(int tableNumber) {
        ArrayList<TimeTable> timeTable = new ArrayList<TimeTable>();
        for (int i = 1; i <= 10; i++) {
            timeTable.add(new TimeTable(i*tableNumber));
        }
        return timeTable;
    }
}
