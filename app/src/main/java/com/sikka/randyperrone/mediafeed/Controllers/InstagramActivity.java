package com.sikka.randyperrone.mediafeed.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sikka.randyperrone.mediafeed.Model.DownloadPostService;
import com.sikka.randyperrone.mediafeed.Model.Post;
import com.sikka.randyperrone.mediafeed.R;
import com.sikka.randyperrone.mediafeed.RecyclerView.InstagramRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class InstagramActivity extends AppCompatActivity {
    private final String TAG = "InstagramActivity";
    private String URL = "https://api.instagram.com/v1/tags/sikkasoftware/media/recent?access_token=";
    private RecyclerView recyclerView;
    private InstagramRecyclerAdapter mAdapter;
    private List<Post> listOfPosts;
    private DownloadPostService downloadPostService;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        URL = URL + getString(R.string.access_token);
        listOfPosts = new ArrayList<>();
        downloadPostService = new DownloadPostService(getApplicationContext());
        recyclerView = (RecyclerView)findViewById(R.id.insta_recyclerview);
        mAdapter = new InstagramRecyclerAdapter(listOfPosts);
        recyclerView.setAdapter(mAdapter);
        gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        loadData();
    }

    private void loadData(){
        downloadPostService.downloadPosts(URL, new DownloadPostService.VolleyCallBack() {
            @Override
            public void onSuccessCallback(List<Post> postList) {
                listOfPosts.addAll(postList);
                final int curSize = mAdapter.getItemCount();
                mAdapter.notifyItemRangeInserted(curSize, listOfPosts.size() - 1);
            }
        });
    }
}
