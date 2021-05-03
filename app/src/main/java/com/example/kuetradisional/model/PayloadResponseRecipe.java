package com.example.kuetradisional.model;

import com.google.gson.annotations.SerializedName;

public class PayloadResponseRecipe {
    @SerializedName("version")
    private PayloadVersion version;

    @SerializedName("meta")
    private PayloadMeta meta;

    @SerializedName("data")
    private PayloadDataRecipe data;

    @SerializedName("pagination")
    private PayloadPagination pagination;

    public PayloadResponseRecipe(PayloadVersion version, PayloadMeta meta, PayloadDataRecipe data, PayloadPagination pagination) {
        this.version = version;
        this.meta = meta;
        this.data = data;
        this.pagination = pagination;
    }

    public PayloadVersion getVersion() {
        return version;
    }

    public PayloadMeta getMeta() {
        return meta;
    }

    public PayloadDataRecipe getData() {
        return data;
    }

    public PayloadPagination getPagination() {
        return pagination;
    }
}
