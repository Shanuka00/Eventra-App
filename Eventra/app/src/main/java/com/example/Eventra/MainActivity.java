package com.example.Eventra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //======================================
    //Chamod Malshan - IM/2020/050 (start)
    //======================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadSplashScreen();
    }

    private void loadSplashScreen(){
        Intent splashScreenLoader = new Intent(this, SplashScreen.class);
        startActivity(splashScreenLoader);
    }

    //======================================
    //Chamod Malshan - IM/2020/050 (end)
    //======================================
}