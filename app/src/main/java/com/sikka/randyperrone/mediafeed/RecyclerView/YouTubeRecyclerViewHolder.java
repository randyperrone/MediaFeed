package com.sikka.randyperrone.mediafeed.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sikka.randyperrone.mediafeed.R;

public class YouTubeRecyclerViewHolder extends RecyclerView.ViewHolder{
    private ImageView thumbnail;
    private TextView title, description;

    public YouTubeRecyclerViewHolder(View itemView) {
        super(itemView);
        thumbnail = (ImageView) itemView.findViewById(R.id.video_thumbnail_iv);
        title = (TextView)itemView.findViewById(R.id.video_title_tv);
        description = (TextView)itemView.findViewById(R.id.video_description_tv);
    }

    public void setThumbnail(String url) {
        if(url != null){
            try{
                Glide.with(thumbnail.getContext())
                        .load(url)
                        .into(thumbnail);
            }
            catch (Exception e){
                Log.e("VideoViewholder", e.toString());
            }
        }
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }
}
