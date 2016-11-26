package com.example.aryam.test.controller;

import android.content.Context;
import android.database.Cursor;

import com.example.aryam.test.model.QuestionsData;
import com.example.aryam.test.model.QuzSQliteDbWrapper;

import java.util.List;

/**
 * Created by arya.m on 11/15/2016.
 */
public class Data {




    private Data() {}

    private static Data mInstance;

    private List<QuestionsData> mData, mFilteredData;

    public static Data getInstance() {
        if (mInstance == null)
            mInstance = new Data();
        return mInstance;
    }

    public List<QuestionsData> loadData(Context context) {
        QuzSQliteDbWrapper model = new QuzSQliteDbWrapper();
        if (model.openLocalDb(context)) {
            Cursor cr = model.readAllData();
            mData = QuestionsData.parseTable(cr);
            cr.close();
            model.closeLocalDb();
        }
        return mData;
    }



    public List<QuestionsData> getData() {
        return mData;
    }
}






