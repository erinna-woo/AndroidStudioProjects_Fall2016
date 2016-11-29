package com.example.erinna.aithello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this method already exists in parent class (AppCompatActivity)
        super.onCreate(savedInstanceState);
        //load XML layout file onto window
        setContentView(R.layout.activity_main);
    }
}
