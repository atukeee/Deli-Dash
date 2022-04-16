package com.android.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private  static  int SPLASH_SCREEN=5000;

    Animation leftAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Animation
        leftAnim = AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        //Hooks
        image = findViewById(R.id.image);

        //setting the animation
        image.setAnimation(leftAnim);

        //to hide the action bar on top
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //It is to run after the specified amount of time elapses
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_SCREEN);
    }
}