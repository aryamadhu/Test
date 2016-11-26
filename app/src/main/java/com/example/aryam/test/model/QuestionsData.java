package com.example.aryam.test.model;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    private int mSelectedChoice;

    public void setSelectedChoice(int selectedChoice) {
        mSelectedChoice = selectedChoice;
    }

    public boolean isAnswered() {
        return mSelectedChoice != 0;
    }

    public boolean isAnswerCorrect() {
        return mSelectedChoice == correctch;
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
        row.id = cr.getInt(cr.getColumnIndex("id"));
        row.title = cr.getString(cr.getColumnIndex("Name"));
        row.sub_title = cr.getString(cr.getColumnIndex("Subheading"));

        row.description = new LinkedHashMap<>();
        String column_name, value;
        for (int i=4; i<COLUMNS_IN_ORDER.length; i++) {
            column_name = COLUMNS_IN_ORDER[i];
            value = cr.getString(cr.getColumnIndex(column_name));
            if (value != null
                    && !value.isEmpty()
                    && !column_name.equals("isVerified"))
                row.description.put(column_name, value);
        }

        return row;
    }
}
