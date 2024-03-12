package com.example.Eventra;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    //======================================
    //Chamod Malshan - IM/2020/050 (start)
    //======================================

    ViewGroup transition_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        transition_layout = findViewById(R.id.layout_loadingscreen);

        Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(2000);

        Animation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setStartOffset(4000);
        fadeOut.setDuration(1500);

        AnimationSet animationSet = new AnimationSet(true);

        animationSet.addAnimation(fadeIn);
        animationSet.addAnimation(fadeOut);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                System.out.println("Animation ended");
                loadEventList();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        transition_layout.startAnimation(animationSet);
    }

    private void loadEventList(){
        Intent eventListLoader = new Intent(this, EventList.class);
        startActivity(eventListLoader);
    }

    //======================================
    //Chamod Malshan - IM/2020/050 (end)
    //======================================
}
