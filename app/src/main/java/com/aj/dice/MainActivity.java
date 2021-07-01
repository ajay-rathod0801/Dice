package com.aj.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aj.dice.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding mBinding;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Log.e(TAG, "onCreate: ");

        init();

    }

    private void init() {
        /*Dice Array*/
        final int[] diceArray = new int[]{
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        Log.e(TAG, "init: ");

        /*Button Listing*/
        mBinding.rollButton.setOnClickListener(v -> {
            Roll(diceArray);
        });

    }

    private void Roll(int[] diceArray) {

        Random randomNumberGenerator = new Random();
        int number = randomNumberGenerator.nextInt(6);
        Log.e(TAG, "Roll: " + number);
        mBinding.imageLeftDice.setImageResource(diceArray[number]);
        number = randomNumberGenerator.nextInt(6);
        mBinding.imageRightDice.setImageResource(diceArray[number]);

    }


}