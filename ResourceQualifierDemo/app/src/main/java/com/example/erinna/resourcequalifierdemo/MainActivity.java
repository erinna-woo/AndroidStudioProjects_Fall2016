package com.example.erinna.resourcequalifierdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //RESOURCE QUALIFIER: landscape - just one qualifier type
        setContentView(R.layout.activity_main);
    }
}
