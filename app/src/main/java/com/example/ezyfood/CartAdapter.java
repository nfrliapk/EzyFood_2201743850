package com.example.ezyfood;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.JualanViewHolder> {

    private ArrayList<Mycart> cartlist;
    private Context context;

    public CartAdapter(ArrayList<Mycart> cartlist, Context context) {
        if(cartlist == null) cartlist = new ArrayList<>();
        this.cartlist = cartlist;
        this.context = context;
    }

    @NonNull
    @Override
    public JualanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemincart, parent, false);

        return new JualanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JualanViewHolder holder, int position) {
        Mycart cart = cartlist.get(position);
        holder.pictProduk.setImageResource(cart.getPhotoProduk());
        holder.nameProduk.setText(cart.getNamaProduk());
        holder.priceProduk.setText("Total: Rp. " + Integer.valueOf(cart.getHargaProduk() ) * Integer.valueOf(cart.getQty()));
        holder.quantity.setText("Quantity: " + cart.getQty());
        holder.hapusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseSample.cartItems.remove(position);
                notifyDataSetChanged();
                MyOrder.totalPrice.setText(DatabaseSample.getPrice().toString());
            }
        });

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
        private Button hapusButton;

        public JualanViewHolder(@NonNull View itemView){
            super(itemView);
            pictProduk = itemView.findViewById(R.id.photoProduk);
            nameProduk = itemView.findViewById(R.id.namaProduk);
            priceProduk = itemView.findViewById(R.id.hargaProduk);
            quantity = itemView.findViewById(R.id.quantity);
            hapusButton = itemView.findViewById(R.id.hapusButton);
        }
    }
}
