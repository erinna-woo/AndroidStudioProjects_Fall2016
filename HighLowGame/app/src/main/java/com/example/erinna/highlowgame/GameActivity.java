package com.example.erinna.highlowgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity{
// TODO: counter for counting the number of guesses!
    //then you can say like "YOU WON IN X STEPS!"

    public static final String KEY_GEN = "KEY_GEN";
    private int generatedNum = 0;
    private int numGuesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //intead of locking in portrait
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_GEN)) {
            generatedNum = savedInstanceState.getInt(KEY_GEN,0);
        } else{
            generateNewNumber();
        }

        final EditText etGuess = (EditText) findViewById(R.id.etGuess);
        final TextView tvStatus = (TextView) findViewById(R.id.tvStatus);
        final TextView tvNumGuesses = (TextView) findViewById(R.id.tvNumGuesses);

        Button btnGuess = (Button) findViewById(R.id.btnGuess);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(etGuess.getText().toString())) {
                    numGuesses++;
                    tvNumGuesses.setText("Number of Guesses: " + numGuesses);


                    int guess = Integer.parseInt(etGuess.getText().toString());
                    //but what if this cannot be parsed? empty? !@#%!@#%?
                    //we could do try/catch, but it doesn't tell the user what is wrong
                    //==> we could use a keyboard with only numbers (EditText -> numbers)
                    if (guess < generatedNum) {
                        tvStatus.setText("The number is higher.");
                    } else if (guess > generatedNum) {
                        tvStatus.setText("The number is lower.");
                    } else if (guess == generatedNum) {
                        tvStatus.setText("YOU HAVE WON!");

                        //this just opens the activity:
                        startActivity(new Intent(GameActivity.this, ResultActivity.class));

                        //opening activity as a dialogue
                        //set in AndroidManifest.xml: android:theme="@style/Theme.AppCompat.Dialog"


                    } else {
                        tvStatus.setText("This cannot happen :) ");
                    }
                }
                else { // Not snackbar
                    etGuess.setError("This field cannot be empty");
                }
            }
        });
    }

    //save the number
    // so on create we get this number, reinitialize our generated num
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_GEN, generatedNum);
//                cmd option C --> create constant
    }

    private void generateNewNumber() {
        Random rand = new Random(System.currentTimeMillis());
        generatedNum = rand.nextInt(10); //100 is excluded
    }
}
