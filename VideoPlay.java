package com.example.codingstuff;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlay extends AppCompatActivity {

    VideoView videoView;
    String uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        videoView=findViewById(R.id.videoView);
        uri=getIntent().getExtras().getString("position");
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();
    }
}