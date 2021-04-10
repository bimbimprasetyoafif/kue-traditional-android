package com.example.kuetradisional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainReceipe extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyDVQWxtDu4AVx5GF4Alqr5zmRyV_f5T40s";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receipe);

        final YouTubePlayerView youtubePlayerView = findViewById(R.id.youtubePlayerView);
        playVideo("cGkSY3w05G4", youtubePlayerView);
    }

    public void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {
        try {
            youTubePlayerView.initialize(API_KEY,
                    new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                            YouTubePlayer youTubePlayer, boolean b) {
                            youTubePlayer.loadVideo(videoId);
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult youTubeInitializationResult) {
                            Log.e("youtube_failure", youTubeInitializationResult.toString());
                        }
                    });
        } catch (Exception e) {
            Log.e("youtube", e.getMessage());
        }

    }
}