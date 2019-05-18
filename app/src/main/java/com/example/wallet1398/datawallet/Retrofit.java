package com.example.wallet1398.datawallet;


import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    private static retrofit2.Retrofit retrofit;
    private static Api api;

    private static retrofit2.Retrofit getClient() {

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://nightly-alpha.carrene.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public static Api getApi() {
        api = getClient().create(Api.class);
        return api;
    }

}
