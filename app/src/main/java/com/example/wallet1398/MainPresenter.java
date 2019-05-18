package com.example.wallet1398;


import com.example.wallet1398.data.model.User;
import com.example.wallet1398.datawallet.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface.Presenter {


    private User user;
    private MainInterface.View mView;

    public MainPresenter(MainInterface.View view) {
        mView = view;
    }

    @Override
    public void getPassword(String p, String SHA1) {

        Retrofit.getApi().getPassword(p, SHA1).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                user = response.body();
                mView.setUser(user);


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}


