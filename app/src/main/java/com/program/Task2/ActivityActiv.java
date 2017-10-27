package com.program.Task2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivityActiv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        Bundle extras = getIntent().getExtras();
        int value = 1;
        if (extras != null) {
            value = extras.getInt("id");
        }
        FragmentActiv frA = (FragmentActiv) getSupportFragmentManager().findFragmentById(R.id.fragment35);
        frA.setID(value);
    }
}
