package com.example.kuetradisional.api;

import com.example.kuetradisional.model.PayloadResponseKue;
import com.example.kuetradisional.model.PayloadResponseRecipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRequest {

    @GET("{kue_label}")
    Call<PayloadResponseKue> getKue(@Path("kue_label") String kue_label);

    @GET("recipe/{kue_label}")
    Call<PayloadResponseRecipe> getKueRecipe(@Path("kue_label") String kue_label);

}