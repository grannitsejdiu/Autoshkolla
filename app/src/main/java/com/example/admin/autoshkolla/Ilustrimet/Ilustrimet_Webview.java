package com.example.admin.autoshkolla.Ilustrimet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.autoshkolla.Models.Sign;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Ilustrimet_Webview extends YouTubeBaseActivity {

    Button back;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilustrimet__webview);

        int index = getIntent().getIntExtra("index", 0);
        final Sign s = This.illustraions.get(index);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(s.description);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize("AIzaSyAejeo4T9MkERtCYC5q63Fs4Pev8-p5Czk",onInitializedListener);

        back = (Button) findViewById(R.id.youtube_FormBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ilustrimet_Webview.super.onBackPressed();
            }
        });

    }
}
