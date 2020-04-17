package com.example.androidlearningapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {
    private String operation;
    private int number1;
    private int number2;
    private int answer;

    private List<Integer> options;

    enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION
    }

    private static final int DEFAULT_MIN_VALUE = 2;
    private static final int DEFAULT_MAX_VALUE = 20;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Puzzle() {
        this.number1 = (int)(Math.random() * DEFAULT_MAX_VALUE) + DEFAULT_MIN_VALUE;
        this.number2 = (int)(Math.random() * DEFAULT_MAX_VALUE) + DEFAULT_MIN_VALUE;
        this.options =  new ArrayList<Integer>();
        this.operation = "";
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Integer> options) {
        this.options = options;
    }

    protected void getOperation() {
        int rnd = new Random().nextInt(Operation.values().length);
        Operation[] operations =  Operation.values();
        this.operation = String.valueOf(operations[rnd]);;
    }

    protected void generateOptions() {
        this.getOperation();
        Log.i(",,,", "---------------------"+this.operation);
        switch (this.operation) {
            case "ADDITION":
                Log.i(",,,", "---------------------");
                Log.i(",,,", String.valueOf(this.number1));
                Log.i(",,,", String.valueOf(this.number2));
                this.answer = this.number1 + this.number2;
                Log.i(",,,", this.operation);
                Log.i(",,,", String.valueOf(this.answer));
                Log.i(",,,", "---------------------");
                this.options.add(this.answer);
                this.options.add(this.number1 + (int)(Math.random() * this.answer)- 1);
                this.options.add(this.number1 + (int)(Math.random() * this.number2)-this.answer);
                this.options.add(this.number1 + (int)(Math.random() * this.number2)+this.answer);
                break;
            case "SUBTRACTION":
                Log.i(",,,", "---------------------");
                Log.i(",,,", String.valueOf(this.number1));
                Log.i(",,,", String.valueOf(this.number2));
                Log.i(",,,", this.operation);
                this.answer = this.number1 - this.number2;
                Log.i(",,,", this.operation);
                Log.i("answer", String.valueOf(this.answer));
                Log.i(",,,", "---------------------");
                this.options.add(this.answer);
                this.options.add(this.number1 - (int)(Math.random() * this.answer)- 1);
                this.options.add(this.number1 - (int)(Math.random() * this.number2)-this.answer);
                this.options.add(this.number1 - (int)(Math.random() * this.number2)+this.answer);
                break;
            case "MULTIPLICATION":
                Log.i(",,,", "---------------------");
                Log.i(",,,", String.valueOf(this.number1));
                Log.i(",,,", String.valueOf(this.number2));
                Log.i(",,,", this.operation);
                this.answer = this.number1 * this.number2;
                Log.i(",,,", String.valueOf(this.answer));
                Log.i(",,,", "---------------------");
                this.options.add(this.answer);
                this.options.add(this.number1 * (int)(Math.random() * this.answer)- 1);
                this.options.add(this.number1 * (int)(Math.random() * this.number2)-this.answer);
                this.options.add(this.number1 * (int)(Math.random() * this.number2)+this.answer);
                break;
            case "DIVISION":
                Log.i(",,,", "---------------------");
                Log.i(",,,", String.valueOf(this.number1));
                Log.i(",,,", String.valueOf(this.number2));
                this.answer = this.number1 - this.number2;
                Log.i(",,,", String.valueOf(this.answer));
                Log.i(",,,", "---------------------");
                this.options.add(this.answer);
                this.options.add(this.number1 / (int)(Math.random() * this.number2)-1);
                this.options.add(this.number1 / (int)(Math.random() * this.number2)-2);
                this.options.add(this.number1 / (int)(Math.random() * this.number2)-3);
                break;
            default:
                break;
        }
    };

    protected String question() {
        String question = "";
        switch (operation) {
            case "ADDITION":
                question = String.format("%s + %s = ?", number1, number2);
                break;
            case "SUBTRACTION":
                question = String.format("%s - %s = ?", number1, number2);
                break;
            case "MULTIPLICATION":
                question = String.format("%s * %s = ?", number1, number2);
                break;
            case "DIVISION":
                question = String.format("%s / %s = ?", number1, number2);
                break;
            default:
                break;
        }
        return question;
    };

    protected Integer updateOptions() {
        int rnd = new Random().nextInt(this.options.size());
        return this.options.remove(rnd);
    }
}
