package com.example.kuetradisional.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PayloadDataRecipe {
    @SerializedName("youtube_id")
    private String youtube_id;

    @SerializedName("ingredients")
    private ArrayList<String> ingredients;

    @SerializedName("steps")
    private ArrayList<String> steps;

    @SerializedName("resource")
    private String resource;

    public PayloadDataRecipe(String youtube_id, ArrayList<String> ingredients, ArrayList<String> steps, String resource) {
        this.youtube_id = youtube_id;
        this.ingredients = ingredients;
        this.steps = steps;
        this.resource = resource;
    }

    public String getYoutube_id() {
        return youtube_id;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public String getResource() {
        return resource;
    }
}
