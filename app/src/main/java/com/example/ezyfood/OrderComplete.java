package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderComplete extends AppCompatActivity {
    private RecyclerView recyclerviewTransaction;
    private ItemTransAdapter itemtransAdapter;
    private TextView totalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        recyclerviewTransaction = findViewById(R.id.orderList);
        totalHarga = findViewById(R.id.totalprice);

        ArrayList<Mycart> cartitems = new ArrayList<>(DatabaseSample.cartItems);
        totalHarga.setText(DatabaseSample.getPrice().toString());

        //adapter
        itemtransAdapter = new ItemTransAdapter(cartitems, this);
        recyclerviewTransaction.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewTransaction.setAdapter(itemtransAdapter);

        DatabaseSample.cartItems.clear();
        MyOrder.afterPay = true;
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        MyOrder.afterPay = false;
    }
}