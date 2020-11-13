package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnDrink, btnSnacks, btnFoods, btnTopup, btnMyOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDrink = findViewById(R.id.drinksBtn);
        btnSnacks = findViewById(R.id.snacksBtn);
        btnFoods = findViewById(R.id.foodsBtn);
        btnTopup = findViewById(R.id.topupBtn);
        btnMyOrder = findViewById(R.id.myOrderBtn);

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahActivity = new Intent(MainActivity.this, ActivityTest.class);
                pindahActivity.putExtra("type","drinks");
                startActivity(pindahActivity);
            }
        });

        btnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahActivity = new Intent(MainActivity.this, ActivityTest.class);
                pindahActivity.putExtra("type","snacks");
                startActivity(pindahActivity);
            }
        });

        btnFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahActivity = new Intent(MainActivity.this, ActivityTest.class);
                pindahActivity.putExtra("type","foods");
                startActivity(pindahActivity);
            }
        });

        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyOrder.class);
                startActivity(intent);
            }
        });

    }

}