package com.program.Task2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ActivityL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l);
    }


    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentL fragment2 = (FragmentL) fragmentManager.findFragmentById(R.id.fragment);
        if (fragment2 != null)
            fragment2.saveData();
        super.onBackPressed();
    }
}
