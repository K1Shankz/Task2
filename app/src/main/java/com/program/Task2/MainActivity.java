package com.program.Task2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {

        super.onResume();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentMain fragment2 = (FragmentMain) fragmentManager.findFragmentById(R.id.fragmentMain);
        if (fragment2 != null)
            fragment2.getRV();
        Toast.makeText(this, "Clicked aaaa", Toast.LENGTH_SHORT).show();
    }
}
