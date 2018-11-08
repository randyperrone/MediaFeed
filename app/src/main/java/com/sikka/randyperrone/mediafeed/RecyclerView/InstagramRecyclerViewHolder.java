package com.sikka.randyperrone.mediafeed.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.sikka.randyperrone.mediafeed.R;

public class InstagramRecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageButton postImageButton;

    public InstagramRecyclerViewHolder(View itemView) {
        super(itemView);
        postImageButton = (ImageButton)itemView.findViewById(R.id.insta_post_ib);
    }

    public void setImageButton(String url){
        if(url != null){
            try{
                Glide.with(postImageButton.getContext())
                        .load(url)
                        .into(postImageButton);
            }
            catch (Exception e){
                Log.e("PostViewholder", e.toString());
            }
        }
    }
}
