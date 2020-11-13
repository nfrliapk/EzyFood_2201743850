package com.example.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.JualanViewHolder> {

    private final ArrayList<Jualan> listJualan;
    private final Context context;


    public Adapter(ArrayList<Jualan> listJualan, Context context) {
        this.listJualan = listJualan;
        this.context = context;
    }

    @NonNull
    @Override
    public JualanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.drinks_list, parent, false);

        return new JualanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JualanViewHolder holder, int position) {
        Jualan jualan = listJualan.get(position);
        holder.pictProduk.setImageResource(jualan.getPictProduk());
        holder.nameProduk.setText(jualan.getNameProduk());
        holder.priceProduk.setText("Rp. " + jualan.getPriceProduk());
        holder.listitem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Order.class);
                intent.putExtra("photoProduk", jualan.getPictProduk());
                intent.putExtra("namaProduk", jualan.getNameProduk());
                intent.putExtra("hargaProduk", jualan.getPriceProduk());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJualan.size();
    }

    static class JualanViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictProduk;
        private TextView nameProduk;
        private TextView priceProduk;
        private LinearLayout listitem;

        public JualanViewHolder(@NonNull View itemView){
            super(itemView);
            pictProduk = itemView.findViewById(R.id.photoProduk);
            nameProduk = itemView.findViewById(R.id.namaProduk);
            priceProduk = itemView.findViewById(R.id.hargaProduk);
            listitem = itemView.findViewById(R.id.list_item);
        }
    }
}
