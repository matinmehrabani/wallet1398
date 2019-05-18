package com.example.wallet1398.ui.login;

import com.example.wallet1398.data.model.Confirmation;
import com.example.wallet1398.datawallet.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginInterface.Presenter {
    private Confirmation confirmation;
    private LoginInterface.View mView;

    public LoginPresenter(LoginInterface.View view) {
        mView = view;
    }

    @Override
    public void bind(String phone, String uDid, String model, String password) {
        Retrofit.getApi().confirmation(phone, uDid, model, password).enqueue(new Callback<Confirmation>() {
            @Override
            public void onResponse(Call<Confirmation> call, Response<Confirmation> response) {
                if (response.code() == 200) {
                    confirmation = response.body();
                    mView.setConfirmation(confirmation);


                } else {

                    mView.snackBar();
                }
            }

            @Override
            public void onFailure(Call<Confirmation> call, Throwable t) {

            }
        });

    }
}


