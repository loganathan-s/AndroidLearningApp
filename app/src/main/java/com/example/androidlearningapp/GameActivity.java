package com.example.androidlearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    public TextView optionOne;
    public TextView optionTwo;
    public TextView optionThree;
    public TextView optionFour;
    public TextView timer;
    public TextView puzzle;
    public TextView score;
    private Puzzle question;
    private Integer correctAnswer;
    private Integer validTag;
    private Integer userScore;

    public void checkAnswer(View view) {
        int selectedOption = (int) view.getTag();
        if(validTag.equals(selectedOption)) {
            userScore++;
            this.generateNewQuestion();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        userScore = 0;
        optionOne = (TextView) findViewById(R.id.optionOne);
        optionTwo = (TextView) findViewById(R.id.optionTwo);
        optionThree = (TextView) findViewById(R.id.optionThree);
        optionFour = (TextView) findViewById(R.id.optionFour);
        optionOne.setTag(1);
        optionTwo.setTag(2);
        optionThree.setTag(3);
        optionFour.setTag(4);

        timer = (TextView) findViewById(R.id.timer);
        this.generateNewQuestion();
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                score.setText(String.valueOf(userScore)+"/20");
                timer.setText("00:" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("00:00");
                score.setText("0/20");
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }.start();
    }

    protected void generateNewQuestion() {
        question = new Puzzle();
        question.generateOptions();
        puzzle = (TextView) findViewById(R.id.puzzle);
        score = (TextView) findViewById(R.id.score);
        puzzle.setText(question.question());
        Random rand = new Random();
        correctAnswer = question.getAnswer();
        List<Integer> options = question.getOptions();
        for (int i = 0; i < 4; i ++) {
            Integer answer = question.updateOptions();
            switch (i) {
                case 0:
                    if (answer.equals(correctAnswer)) {
                        validTag = 1;
                    }
                    optionOne.setText(String.valueOf(answer));
                    break;
                case 1:
                    if (answer.equals(correctAnswer)) {
                        validTag = 2;
                    }
                    optionTwo.setText(String.valueOf(answer));
                    break;
                case 2:
                    if (answer.equals(correctAnswer)) {
                        validTag = 3;
                    }
                    optionThree.setText(String.valueOf(answer));
                    break;
                case 3:
                    if (answer.equals(correctAnswer)) {
                        validTag = 4;
                    }
                    optionFour.setText(String.valueOf(answer));
                    break;
                default:
                    break;
            };
        }
    }
}
