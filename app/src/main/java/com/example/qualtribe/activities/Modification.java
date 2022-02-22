package com.example.qualtribe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.qualtribe.R;

public class Modification extends AppCompatActivity implements View.OnClickListener {

    ImageView home, message, search, order, profile ;
    Button approve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);

        approve = findViewById(R.id.approve);
        approve.setOnClickListener(this);

        home = findViewById(R.id.home_ic);
        home.setOnClickListener(this);

        message = findViewById(R.id.msg_ic);
        message.setOnClickListener(this);

        search = findViewById(R.id.search_ic);
        search.setOnClickListener(this);

        profile = findViewById(R.id.profile_ic);
        profile.setOnClickListener(this);

        order = findViewById(R.id.order_ic);
        order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.approve:
                startActivity(new Intent(this, Review.class));
                break;

            case R.id.home_ic:
                startActivity(new Intent(this, Homepage.class));
                break;

            case R.id.msg_ic:
                startActivity(new Intent(this, chat.class));
                break;

            case R.id.search_ic:
                startActivity(new Intent(this, loginSearch.class));
                break;

            case R.id.order_ic:
                startActivity(new Intent(this, Contract.class));
                break;

            case R.id.profile_ic:
                startActivity(new Intent(this, loginMenu.class));
                finish();

        }
    }
}