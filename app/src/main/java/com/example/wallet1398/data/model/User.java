package com.example.wallet1398.data.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("udid")
    private String udid;
    @SerializedName("phone")
    private String phone;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public String getPhone() {
        return phone;
    }

    public String getUdid() {
        return udid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
