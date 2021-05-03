package com.example.kuetradisional.model;

import com.google.gson.annotations.SerializedName;

public class PayloadMeta {
    @SerializedName("code")
    private String code;

    public PayloadMeta(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
