package com.example.user.myapplication1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.myapplication1.R;

public class ImageActivity extends AppCompatActivity {
    ImageView iView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        final String iUrl = intent.getStringExtra("iUrl");

        iView = findViewById(R.id.image_image_view);
        Glide.with(this).load(iUrl).into(iView);
    }
}
