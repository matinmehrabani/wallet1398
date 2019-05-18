package com.example.wallet1398.data.model;

import com.google.gson.annotations.SerializedName;

public class Currencies {

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("code")
    private String code;

    @SerializedName("symbol")
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

}


