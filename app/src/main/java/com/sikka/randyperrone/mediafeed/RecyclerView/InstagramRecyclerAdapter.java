package com.sikka.randyperrone.mediafeed.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sikka.randyperrone.mediafeed.Model.Post;
import com.sikka.randyperrone.mediafeed.R;

import java.util.List;

public class InstagramRecyclerAdapter extends RecyclerView.Adapter<InstagramRecyclerViewHolder> {
    private List<Post> listOfPosts;

    public InstagramRecyclerAdapter(List<Post> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }

    @NonNull
    @Override
    public InstagramRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_post_list, parent, false);
        return new InstagramRecyclerViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull InstagramRecyclerViewHolder holder, int position) {
        final Post post = listOfPosts.get(position);
        String url = "";
        if(post != null){
            url = post.getUrl();
        }
        holder.setImageButton(url);
    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }
}
