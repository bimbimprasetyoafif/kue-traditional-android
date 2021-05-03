package com.example.kuetradisional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.kuetradisional.api.ApiRequest;
import com.example.kuetradisional.api.Client;
import com.example.kuetradisional.model.PayloadResponseKue;
import com.example.kuetradisional.model.PayloadResponseRecipe;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.checkerframework.checker.units.qual.C;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainReceipe extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyDVQWxtDu4AVx5GF4Alqr5zmRyV_f5T40s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receipe);

        String label = getIntent().getStringExtra("LABEL");

        Retrofit rClient = Client.getClient();
        rClient.create(ApiRequest.class).getKueRecipe(label)
                .enqueue(new Callback<PayloadResponseRecipe>() {
                    @Override
                    public void onResponse(Call<PayloadResponseRecipe> call, Response<PayloadResponseRecipe> response) {
                        String yID = response.body().getData().getYoutube_id();

                        final YouTubePlayerView youtubePlayerView = findViewById(R.id.youtubePlayerView);
                        playVideo(yID, youtubePlayerView);
                    }

                    @Override
                    public void onFailure(Call<PayloadResponseRecipe> call, Throwable t) {
                        Log.e("API CLIENT RESPONSE ERROR", t.getMessage());
                    }
                });
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