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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_media);

        youtubeButton = (ImageButton)findViewById(R.id.goto_youtube_button);
        //TODO do instagram button and add logo in res

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                startActivity(intent);
            }
        });


    }
}
