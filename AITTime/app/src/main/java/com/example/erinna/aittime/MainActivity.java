package com.example.erinna.aittime;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTime = (Button) findViewById(R.id.btnTime);
        final TextView tvDate = (TextView) findViewById(R.id.tvDate);
        final EditText name = (EditText) findViewById(R.id.username);
        final LinearLayout layoutContent = (LinearLayout) findViewById(R.id.layoutContent);


        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime(tvDate, name.getText().toString(),layoutContent);

            }
        });

    }

    private void showTime(TextView tvDate, String name, LinearLayout layout) {
        String time = "Hello " + name
                + ". The current time is: " + new Date(System.currentTimeMillis()).toString();
//        Toast.makeText(MainActivity.this,
//                time,
//                Toast.LENGTH_LONG).show();

        tvDate.setText(time);
        Snackbar.make(layout, time, Snackbar.LENGTH_LONG).show();


    }
}
