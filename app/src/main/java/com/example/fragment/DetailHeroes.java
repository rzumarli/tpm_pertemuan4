package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailHeroes extends AppCompatActivity {

    private ImageView ivHero;
    private TextView tvName,tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_heroes);

        ivHero = findViewById(R.id.activity_iv);
        tvName = findViewById(R.id.activity_tv_name);
        tvDes = findViewById(R.id.activity_tv_des);

        String Name = getIntent().getStringExtra("Name");
        String Des = getIntent().getStringExtra("Des");
        int Image = getIntent().getIntExtra("Image",0);

        Glide.with(getApplicationContext()).load(Image).into(ivHero);
        tvName.setText(Name);
        tvDes.setText(Des);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
