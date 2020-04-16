package com.example.androidlearningapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TextView timerView;
    private Button timerButton;
    private int alarmTime;
    private boolean timerActive = false;
    private AlarmTimer alarmTimer;
    private CountDownTimer countDownTimer;
    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(1800);

        timerView = (TextView) findViewById(R.id.timerView);
        timerView.setGravity(Gravity.CENTER);

        timerButton = (Button) findViewById(R.id.timerButton);
        timerButton.setText("Start");
        timerButton.setEnabled(false);
        alarmTimer = new AlarmTimer();
        appContext = getApplicationContext();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int millisUntilFinished = (progress * 1000);
                if (millisUntilFinished > 0) {
                    String text = String.format(Locale.getDefault(), "%02d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                    timerView.setText(text);
                    timerButton.setEnabled(true);
                } else if (timerActive) {
                    timerActive = false;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        timerButton.setOnClickListener(new View.OnClickListener() {
            CountDownTimer countdownTimer = null;
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (!timerActive) {
                    alarmTime = seekBar.getProgress();
                    countdownTimer = alarmTimer.startTimer(alarmTime, 0, timerView, seekBar, timerButton, appContext);
                    countdownTimer.start();
                    timerButton.setText("Stop");
                    seekBar.setEnabled(false);
                    timerActive = true;
                } else if (countdownTimer !=null) {
                        countdownTimer.cancel();
                        timerActive = false;
                        seekBar.setProgress(0);
                        seekBar.setEnabled(true);
                        timerView.setText("00:00");
                        timerButton.setText("Start");
                }
            }
        });
    }
}


