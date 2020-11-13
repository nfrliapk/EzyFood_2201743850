package com.example.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemTransAdapter extends RecyclerView.Adapter<ItemTransAdapter.JualanViewHolder> {

    private ArrayList<Mycart> cartlist;
    private Context context;

    public ItemTransAdapter(ArrayList<Mycart> cartlist, Context context) {
        this.cartlist = cartlist;
        this.context = context;
    }

    @NonNull
    @Override
    public JualanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);

        return new JualanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JualanViewHolder holder, int position) {
        Mycart cart = cartlist.get(position);
        holder.pictProduk.setImageResource(cart.getPhotoProduk());
        holder.nameProduk.setText(cart.getNamaProduk());
        holder.priceProduk.setText("Total: Rp. " + (Integer.valueOf(cart.getHargaProduk()) * Integer.valueOf(cart.getQty())));
        holder.quantity.setText("Quantity: " + cart.getQty());
    }

    @Override
    public int getItemCount() {
        return cartlist.size();
    }

    static class JualanViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictProduk;
        private TextView nameProduk;
        private TextView priceProduk;
        private TextView quantity;

        public JualanViewHolder(@NonNull View itemView){
            super(itemView);
            pictProduk = itemView.findViewById(R.id.photoProduk);
            nameProduk = itemView.findViewById(R.id.namaProduk);
            priceProduk = itemView.findViewById(R.id.hargaProduk);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}