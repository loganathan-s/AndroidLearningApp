package com.example.androidlearningapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.androidlearningapp.R;
import com.example.androidlearningapp.model.TimeTable;

import java.util.ArrayList;
import java.util.List;
public class TimesTableAdapter extends
        RecyclerView.Adapter<TimesTableAdapter.ViewHolder> {

    private List<TimeTable> timeTableData;
    private Context mContext;

    public TimesTableAdapter( Context mContext, ArrayList<TimeTable> timeTableData) {
        this.timeTableData = timeTableData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_times_table, parent,  false);
                ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i(">>>", "onBindViewHolder CALLED");
        TimeTable timetable = timeTableData.get(position);
        final String tableValueText = String.valueOf(timetable.getTableValue());
        holder.tableValue.setText(tableValueText);
        holder.timesTableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onBindViewHolder", "Item Clicked");
                Toast.makeText(mContext, tableValueText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tableValue;
        RelativeLayout timesTableLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tableValue = itemView.findViewById(R.id.tableValueView);
            timesTableLayout = itemView.findViewById(R.id.timesTableLayout);
        }
    }

    public void clear() {
        timeTableData.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<TimeTable> list) {
        timeTableData.addAll(list);
        notifyDataSetChanged();
    }
}

//public class TimeTableAdapter extends
//        RecyclerView.Adapter<TimeTableAdapter.ViewHolder> {
//
//
//    private List<TimeTable> timeTableData;
//    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;
//
//    // data is passed into the constructor
//    public TimeTableAdapter(Context context, List<TimeTable> data) {
//        this.mInflater = LayoutInflater.from(context);
//        this.timeTableData = data;
//    }
//
//    // inflates the row layout from xml when needed
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.from(parent.getContext())
//                .inflate(android.R.layout.simple_list_item_1, parent, false);
//        return new ViewHolder(view);
//    }
//
//    // binds the data to the TextView in each row
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        TimeTable timetable = timeTableData.get(position);
//        holder.myTextView.setText(String.valueOf(timetable.getTableValue()));
//    }
//
//    // total number of rows
//    @Override
//    public int getItemCount() {
//        return timeTableData.size();
//    }
//
//
//    // convenience method for getting data at click position
//    Integer getItem(int id) {
//        return timeTableData.get(id).getTableValue();
//    }
//
//    // allows clicks events to be caught
//    void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = itemClickListener;
//    }
//
//    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
//}