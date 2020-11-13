package com.example.ezyfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.ezyfood.DatabaseSample.cartItems;
import static com.example.ezyfood.DatabaseSample.getPrice;

public class MyOrder extends AppCompatActivity {
    private CartAdapter cartAdapter;
    public static TextView totalPrice;
    public static boolean afterPay = false;
    private Button btnPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        btnPayNow = findViewById(R.id.payNowBtn);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrder.this, OrderComplete.class);
                startActivity(intent);
            }
        });

        totalPrice = findViewById(R.id.totalprice);
        totalPrice.setText(DatabaseSample.getPrice().toString());

        //adapter
        RecyclerView recyclerviewCart = findViewById(R.id.recyclerviewcart);

        cartAdapter = new CartAdapter(cartItems, this);
        recyclerviewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewCart.setAdapter(cartAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(afterPay){
            totalPrice.setText(getPrice().toString());
            cartAdapter.notifyDataSetChanged();
            afterPay = false;
        }
    }
}