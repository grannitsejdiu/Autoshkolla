package com.example.admin.autoshkolla.Ilustrimet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.autoshkolla.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Ilustrimet_Webview extends YouTubeBaseActivity {

    Button play, back;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    ImageView youtube_thumnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilustrimet__webview);

        youtube_thumnail = (ImageView) findViewById(R.id.youtube_thumbnail);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("W1UvCjj2cvQ");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        play = (Button) findViewById(R.id.youtube_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize("AIzaSyAejeo4T9MkERtCYC5q63Fs4Pev8-p5Czk",onInitializedListener);
                play.setVisibility(View.GONE);
                youtube_thumnail.setVisibility(View.GONE);

            }
        });

        back = (Button) findViewById(R.id.youtube_FormBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ilustrimet_Webview.super.onBackPressed();
            }
        });

    }
}
