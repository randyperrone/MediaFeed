package com.sikka.randyperrone.mediafeed.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.sikka.randyperrone.mediafeed.R;

public class ChooseMediaActivity extends AppCompatActivity {
    private ImageButton youtubeButton;
    private ImageButton instagramButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_media);

        youtubeButton = (ImageButton)findViewById(R.id.goto_youtube_button);
        instagramButton = (ImageButton)findViewById(R.id.goto_insta_button);

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                startActivity(intent);
            }
        });
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InstagramActivity.class);
                startActivity(intent);
            }
        });

    }
}
