package com.sikka.randyperrone.mediafeed.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sikka.randyperrone.mediafeed.Controllers.YoutubePlayerActivity;
import com.sikka.randyperrone.mediafeed.Model.Video;
import com.sikka.randyperrone.mediafeed.R;

import java.util.List;

public class YouTubeRecyclerAdapter extends RecyclerView.Adapter<YouTubeRecyclerViewHolder> {
    private List<Video> videoList;

    public YouTubeRecyclerAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public YouTubeRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_video_list, parent, false);
        return new YouTubeRecyclerViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull YouTubeRecyclerViewHolder holder, int position) {
        final Video video = videoList.get(position);
        String title = "";
        String description = "";
        String url = "";
        if(video != null){
            title = video.getTitle();
            description = video.getDescription();
            url = video.getUrl();
        }
        holder.setDescription(description);
        holder.setTitle(title);
        holder.setThumbnail(url);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), YoutubePlayerActivity.class);
                intent.putExtra("video", video);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
