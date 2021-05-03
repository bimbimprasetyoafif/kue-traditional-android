package com.example.kuetradisional.model;

import com.google.gson.annotations.SerializedName;

public class PayloadDataKue {
    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PayloadDataKue(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
