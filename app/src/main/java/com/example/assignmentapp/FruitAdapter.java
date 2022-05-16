package com.example.assignmentapp;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentapp.ui.FruitModel;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    Context context;
    ArrayList<FruitModel> fruitModelArrayList;

    public FruitAdapter(Context context, ArrayList<FruitModel> fruitModelArrayList) {
        this.context = context;
        this.fruitModelArrayList = fruitModelArrayList;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FruitViewHolder(LayoutInflater.from(context).inflate(
                R.layout.item_fruits, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
      FruitModel model = fruitModelArrayList.get(position);
      holder.priceTv.setText("₹"+model.getCurrentPrice());
        holder.originalTv.setText(model.getOriginalPrice());
        holder.nameTv.setText(model.getName());
        holder.originalTv.setPaintFlags(holder.originalTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.discountTv.setText("₹"+model.getDiscount()+" off");
        holder.countTv.setText(model.getWeight()+"Kg");
        holder.imageIv.setImageDrawable(model.getImage());


    }

    @Override
    public int getItemCount() {
        return fruitModelArrayList.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder{
        TextView originalTv,priceTv,discountTv,countTv,nameTv;
        ImageView imageIv;
        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.fruit_name);
            originalTv = itemView.findViewById(R.id.original_price);
            priceTv = itemView.findViewById(R.id.price);
            discountTv = itemView.findViewById(R.id.discount);
            countTv = itemView.findViewById(R.id.countTV);
            imageIv = itemView.findViewById(R.id.image_fruit);

        }
    }
}
