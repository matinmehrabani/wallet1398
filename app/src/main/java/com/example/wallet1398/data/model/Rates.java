package com.example.wallet1398.data.model;

import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("buy")
    private Float buy;

    @SerializedName("id")
    private Integer id;

    public Float getBuy() {
        return buy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}


