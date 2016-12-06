package com.example.aryam.test.model;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arya.m on 11/16/2016.
 */
public class QuestionsData {

    public int qid;
    public String question;
    public String ch1;
    public String ch2;
    public String ch3;
    public String ch4;
    public int correctch;

    public char types;

    // LOCAL
    QuestionsData() {}

    public int getId() {
        return qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCh1() {
        return ch1;
    }
    public String getCh2() {
        return ch2;
    }
    public String getCh3() {
        return ch3;
    }
    public String getCh4() {
        return ch4;
    }
    public int gecorrectch() {
        return correctch;
    }


    public static List<QuestionsData> parseTable(Cursor cr) {
        ArrayList<QuestionsData> QuestionsList = new ArrayList<>();
        if (cr != null && cr.moveToFirst()) {
            do {
                QuestionsList.add(parseRow(cr));
            } while (cr.moveToNext());
        }

        return QuestionsList;
    }
    private static QuestionsData parseRow(Cursor cr) {
        QuestionsData row = new QuestionsData();
        row.qid = cr.getInt(cr.getColumnIndex("id"));
        row.question = cr.getString(cr.getColumnIndex("Question"));
        row.ch1 = cr.getString(cr.getColumnIndex("ch1"));
        row.ch2 = cr.getString(cr.getColumnIndex("ch2"));
        row.ch3 = cr.getString(cr.getColumnIndex("ch3"));
        row.ch4 = cr.getString(cr.getColumnIndex("ch4"));
        row.correctch = cr.getInt(cr.getColumnIndex("correctchoice"));

        return row;
    }
}
