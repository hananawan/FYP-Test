package com.example.qualtribe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qualtribe.R;
import com.example.qualtribe.databinding.ActivityOrderSubmitBinding;
import com.example.qualtribe.models.SubmittedOrder;
import com.example.qualtribe.utils.Constants;
import com.google.firebase.database.FirebaseDatabase;

public class order_submit extends AppCompatActivity implements View.OnClickListener {

    ImageView message, order, profile;
    ActivityOrderSubmitBinding binding;
    String orderId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderSubmitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        orderId = getIntent().getStringExtra(Constants.KEY_ORDER_ID);

        message = findViewById(R.id.msg_ic);
        message.setOnClickListener(this);

        profile = findViewById(R.id.profile_ic);
        profile.setOnClickListener(this);

        order = findViewById(R.id.order_ic);
        order.setOnClickListener(this);


        binding.submitReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String requirements = binding.requirements.getText().toString();
                if (requirements.isEmpty()) {
                    Toast.makeText(order_submit.this, "Requiements cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                submitOrder(requirements);
            }
        });

    }

    private void submitOrder(String requirements) {
        SubmittedOrder order = new SubmittedOrder(requirements, orderId);
        FirebaseDatabase.getInstance().getReference()
                .child("submitted-orders")
                .push()
                .setValue(order);

//        FirebaseDatabase.getInstance().getReference()
//                .child("orders")
//                .child(orderId)
//                .removeValue();

        startActivity(new Intent(this, Seller_Home.class));
        finish();
        Toast.makeText(this, "Order submitted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.msg_ic:
                startActivity(new Intent(this, sellerchat.class));
                break;

            case R.id.order_ic:
                startActivity(new Intent(this, seller_order.class));
                break;


            case R.id.profile_ic:
                startActivity(new Intent(this, sellermenu.class));
                break;


        }

    }
}