package com.example.aryam.test;

import android.app.Activity;
import android.os.Bundle;

import com.example.aryam.test.controller.Data;

/**
 * Created by arya.m on 11/14/2016.
 */


public class QuestionsActivity extends Activity {


    QuestionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_qstpge);

        // Data.getInstance().loadData(this);
        //adapter = new QuestionListAdapter(this, Data.getInstance().getData());
        Data.getInstance().loadData(this);
        adapter = new QuestionListAdapter(this, Data.getInstance().getData());

    }

}
