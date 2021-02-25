package com.jmdevs.petagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.jmdevs.petagram.R;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar actionBar2 = (Toolbar) findViewById(R.id.action_bar2);
        setSupportActionBar(actionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}