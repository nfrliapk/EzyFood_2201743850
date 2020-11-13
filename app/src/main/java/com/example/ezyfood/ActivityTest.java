package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivityTest extends AppCompatActivity {
    private Button btnMyOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnMyOrder = findViewById(R.id.myOrderBtn);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTest.this, MyOrder.class);
                startActivity(intent);
            }
        });

        RecyclerView rvJualan = findViewById(R.id.recyclerviewjualan);

        Intent intent = getIntent();

        String type = intent.getStringExtra("type");
        ArrayList<Jualan> jualans = new ArrayList<>();
        setTitle("Menu");
        switch (type) {
            case "drinks":
                jualans = getDummyDrinksItem();
                break;
            case "snacks":
                jualans = getDummySnacksItem();
                break;
            case "foods":
                jualans = getDummyFoodsItem();
                break;
        }

        Adapter adapter1 = new Adapter(jualans, this);

        rvJualan.setLayoutManager(new LinearLayoutManager(this) );
        rvJualan.setAdapter(adapter1);
    }

    private ArrayList<Jualan> getDummyDrinksItem(){
        ArrayList<Jualan> drinks = new ArrayList<>();
        drinks.add(new Jualan(R.drawable.mineralwaterr, "Air Mineral", "8000"));
        drinks.add(new Jualan(R.drawable.applejuice, "Jus Apel", "12000"));
        drinks.add(new Jualan(R.drawable.mangojuice, "Jus Mangga", "10000"));
        drinks.add(new Jualan(R.drawable.avocadojuice, "Jus Alpukat", "14000"));
        return drinks;
    }
    private ArrayList<Jualan> getDummySnacksItem(){
        ArrayList<Jualan> snacks = new ArrayList<>();
        snacks.add(new Jualan(R.drawable.chitato, "Chitato", "5000"));
        snacks.add(new Jualan(R.drawable.chitato, "Cheetos", "5000"));
        snacks.add(new Jualan(R.drawable.chitato, "Lays", "5000"));
        snacks.add(new Jualan(R.drawable.chitato, "Potabee", "5000"));
        return snacks;

    }
    private ArrayList<Jualan> getDummyFoodsItem(){
        ArrayList<Jualan> foods = new ArrayList<>();
        foods.add(new Jualan(R.drawable.friedrice, "Nasi Goreng", "20000"));
        foods.add(new Jualan(R.drawable.friedrice, "Nasi Uduk", "20000"));
        foods.add(new Jualan(R.drawable.friedrice, "Nasi Tumpeng", "20000"));
        foods.add(new Jualan(R.drawable.friedrice, "Nasi Kuning", "20000"));
        return foods;
    }

}