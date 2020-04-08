package com.example.searchviewrecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView judulMeme;
    ImageView Meme;
    private ItemClickListener itemClickListener;

    public ViewHolder(View view) {
        super(view);
        this.Meme= (ImageView) itemView.findViewById(R.id.meme);
        this.judulMeme= (TextView) itemView.findViewById(R.id.memetitle);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }
    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
