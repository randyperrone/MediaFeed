package com.sikka.randyperrone.mediafeed.Controllers;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sikka.randyperrone.mediafeed.Controllers.Fragments.ListVideosFragment;
import com.sikka.randyperrone.mediafeed.R;

public class YoutubeActivity extends AppCompatActivity implements ListVideosFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        ListVideosFragment fragment = new ListVideosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
