package com.android.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
//package for animation
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
//package for image
import android.widget.ImageView;
//package for Text
import android.widget.TextView;

import com.android.foodorderapp.model.RestaurantModel;

public class OrderSucceessActivity extends AppCompatActivity {

    // Declare Animation object references for the images
    Animation topAnim,botAnim;
    // Declare Image and texts
    ImageView image;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_succeess);

        //Get the handles of the animation for the images
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //Hooks
        image = findViewById(R.id.image);
        details = findViewById(R.id.details);

        //setting the animation from top to the place of the image
        image.setAnimation(topAnim);
        //setting the animation from bottom to the place of the image
        details.setAnimation(botAnim);

        //to hide the actionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        actionBar.setDisplayHomeAsUpEnabled(false);


        TextView buttonDone = findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call finish() method to finish OrderSuccessful Activity
                finish();
            }
        });
    }
}
