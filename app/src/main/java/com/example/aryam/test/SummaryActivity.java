package com.example.aryam.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by arya.m on 11/12/2016.
 */
public class SummaryActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                showQuestionsScreen();
            }
        });
        //getQuestionsFromServer();
    }

    private void showQuestionsScreen() {
        Intent i = new Intent(SummaryActivity.this, QuestionsActivity.class);
        i.putExtra("selected_subject", getIntent().getStringExtra("selected_subject"))
                .putExtra("selected_topic", getIntent().getStringExtra("selected_topic"));
        startActivity(i);
    }
}