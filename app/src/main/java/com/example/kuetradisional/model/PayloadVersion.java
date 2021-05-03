package com.example.kuetradisional.model;

import com.google.gson.annotations.SerializedName;

public class PayloadVersion {
    @SerializedName("label")
    private String label;

    @SerializedName("number")
    private String number;

    public PayloadVersion(String label, String number) {
        this.label = label;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public String getNumber() {
        return number;
    }
}
