package com.example.codingstuff;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubePlayer extends YouTubeBaseActivity {

    String videoUri;
    YouTubePlayerView playerView;
    com.google.android.youtube.player.YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_player);
        playerView=findViewById(R.id.player);
        videoUri=getIntent().getExtras().getString("position");
        onInitializedListener=new com.google.android.youtube.player.YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(com.google.android.youtube.player.YouTubePlayer.Provider provider, com.google.android.youtube.player.YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoUri);
            }

            @Override
            public void onInitializationFailure(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        playerView.initialize(DeveloperKey.KEY,onInitializedListener);
    }
}