package com.example.androidlearningapp;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AlarmTimer {
    public CountDownTimer startTimer(int seconds, int minutes, final TextView timerView, final SeekBar seekBar, final Button button, final Context appContext) {
        //int mins = Integer.parseInt(minTextView.getText().toString());
        //int secs = Integer.parseInt(secTextView.getText().toString());
        long milliSeconds = (minutes * 60 + seconds) * 1000L;
        int countDownIntervalInSeconds = 1;

        CountDownTimer countDownTimer = new CountDownTimer(milliSeconds, countDownIntervalInSeconds * 1000) {
            public void onTick(long millisUntilFinished) {
                String text = String.format(Locale.getDefault(), "%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                timerView.setText(text);
            }

            public void onFinish() {
                final MediaPlayer mediaPlayer = MediaPlayer.create(appContext , R.raw.audio);
                mediaPlayer.start();
                timerView.setText("00:00");
                button.setText("Start");
                seekBar.setEnabled(true);
                seekBar.setProgress(0);
                new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            mediaPlayer.stop();
                        }
                    },
                    10000);
            }
        };
        return countDownTimer;
    }
}