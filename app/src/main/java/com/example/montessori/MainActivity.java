package com.example.montessori;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;


    //variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks

        image = findViewById(R.id.imageview);
        logo = findViewById(R.id.textview);
        slogan = findViewById(R.id.textview2);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image ,"logo_image");
                pairs[1] = new Pair<View,String>(logo ,"logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                SharedPreferences sharedPreferences=getSharedPreferences(Login.Prefs_Name,0);
                boolean hasloggedin= sharedPreferences.getBoolean("hasLoggedIn",false);
                if(hasloggedin) {

                    Intent homeIntent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(homeIntent,options.toBundle());
                    finish();
                }
                else{
                    Intent intent=new Intent(MainActivity.this,Login.class);
                    startActivity(intent,options.toBundle());
                    finish();
                }

            }
        },SPLASH_SCREEN);





    }
}