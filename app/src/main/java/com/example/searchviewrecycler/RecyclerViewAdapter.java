package com.example.searchviewrecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {
    public List<DataFilter> players;
    private List<DataFilter> filterList;
    private Context context;
    CustomFilter filter;

    public RecyclerViewAdapter(MainActivity context, List<DataFilter> players) {
        this.context=context;
        this.players=players;
        this.filterList=players;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataFilter currentItem = players.get(position);
        holder.judulMeme.setText(currentItem.getNama());
        holder.Meme.setImageResource(currentItem.getImageID());
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                if (players.get(pos).getNama().equals("Home")){
                    Intent home = new Intent(context, meme1.class);
                    context.startActivity(home);
                }
                else if (players.get(pos).getNama().equals("Contacts")){
                    Intent contacts = new Intent(context, meme2.class);
                    context.startActivity(contacts);
                }
                else if (players.get(pos).getNama().equals("Images")){
                    Toast.makeText(context, "Images...", Toast.LENGTH_SHORT).show();
                }
                else if (players.get(pos).getNama().equals("Videos")){
                    Toast.makeText(context, "Videos...", Toast.LENGTH_SHORT).show();
                }
                else if (players.get(pos).getNama().equals("Mails")){
                    Toast.makeText(context, "Mails...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return players.size();
    }
    public CustomFilter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }


}




