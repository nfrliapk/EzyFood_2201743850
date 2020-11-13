package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {
    private ImageView pictProduk;
    private TextView nameProduk;
    private TextView priceProduk;
    private EditText qtyProduk;
    private Integer photoProduk;
    private String namaProduk, hargaProduk;
    private Button BtnMyOrder, BtnOrder, BtnOrderMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        BtnMyOrder = findViewById(R.id.myOrderBtn);
        BtnOrder = findViewById(R.id.orderBtn);
        BtnOrderMore = findViewById(R.id.ordermoreBtn);

        BtnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, MyOrder.class);
                startActivity(intent);
            }
        });

        BtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = qtyProduk.getText().toString();
                if (!isQtyValid(quantity)){
                    Toast.makeText(Order.this, "Please input quantity", Toast.LENGTH_SHORT).show();
                }
                else{
                    Mycart cart = new Mycart(photoProduk, namaProduk, hargaProduk, quantity);
                    DatabaseSample.addItem(cart);
                    Toast.makeText(Order.this, "Success!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        BtnOrderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();

        photoProduk = intent.getIntExtra("photoProduk", 0);
        namaProduk = intent.getStringExtra("namaProduk");
        hargaProduk = intent.getStringExtra("hargaProduk");

        pictProduk = findViewById(R.id.photoitem);
        nameProduk = findViewById(R.id.namaitem);
        priceProduk = findViewById(R.id.hargaitem);
        qtyProduk = findViewById(R.id.qty);

        pictProduk.setImageResource(photoProduk);
        nameProduk.setText(namaProduk);
        priceProduk.setText(hargaProduk);
    }

    private boolean isQtyValid(String quantity){
        return quantity!=null && !quantity.equals("");
    }
}