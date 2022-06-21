package com.example.montessori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickeditemActivity2 extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickeditem2);

        imageView = findViewById(R.id.imageview);
        textView = findViewById(R.id.textview);

        Intent intent = getIntent();

        if (intent.getExtras() != null){
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image" ,0);

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);
        }

        //set value;
    }
}