package com.example.erinna.multiactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_SIZE = "KEY_SIZE";
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);

        Button btnEasy = (Button) findViewById(R.id.btnEasy);
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameWithSize(3);
            }
        });
    }

    private void startGameWithSize(int size) {
        Intent intentStartGame = new Intent();
        intentStartGame.setClass(this, GameActivity.class);

        //we have to pass the parameter
        intentStartGame.putExtra(KEY_NAME, etName.getText().toString());
        intentStartGame.putExtra(KEY_SIZE, size);

        //set flags = message to android system, how to open activity
        //opens the new activity and clears all other activities in the back stack

        //When used? going through a few pages, click "X". go back to main menu
        // don't want to go "back" to that very very last page.
        intentStartGame.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        finish(); //takes it off the activity stack // can't go back

        startActivity(intentStartGame);
    }
}
