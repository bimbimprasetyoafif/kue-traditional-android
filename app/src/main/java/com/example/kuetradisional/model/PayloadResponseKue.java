package com.example.kuetradisional.model;

import com.google.gson.annotations.SerializedName;

public class PayloadResponseKue {
    @SerializedName("version")
    private PayloadVersion version;

    @SerializedName("meta")
    private PayloadMeta meta;

    @SerializedName("data")
    private PayloadDataKue data;

    @SerializedName("pagination")
    private PayloadPagination pagination;

    public PayloadResponseKue(PayloadVersion version, PayloadMeta meta, PayloadDataKue data, PayloadPagination pagination) {
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

    public PayloadDataKue getData() {
        return data;
    }

    public PayloadPagination getPagination() {
        return pagination;
    }
}