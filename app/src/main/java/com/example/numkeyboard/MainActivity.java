package com.example.numkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ObbInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumKeyBoardView keyboard = findViewById(R.id.keyboard);
        keyboard.setLinster(new NumKeyBoardView.OnKeyPressLinster() {
            @Override
            public void onNumberPress(int number) {
                Log.e("TAG", "onNumberPress: "+number);
            }

            @Override
            public void onBackPress() {

            }
        });
    }
}