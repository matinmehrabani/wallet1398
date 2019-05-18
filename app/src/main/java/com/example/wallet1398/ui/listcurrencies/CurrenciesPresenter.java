package com.example.wallet1398.ui.listcurrencies;

import com.example.wallet1398.data.model.Currencies;
import com.example.wallet1398.datawallet.Retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrenciesPresenter implements CurrenciesInterface.Presenter {


    private List<Currencies> list;
    private CurrenciesInterface.View mView;

    public CurrenciesPresenter(CurrenciesInterface.View mview) {
        this.mView = mview;
    }

    @Override
    public void getCurrencies() {
        Retrofit.getApi().getList().enqueue(new Callback<List<Currencies>>() {
            @Override
            public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {
                list = new ArrayList<>();
                list = response.body();
                mView.setCurrencies(list);


            }

            @Override
            public void onFailure(Call<List<Currencies>> call, Throwable t) {

            }
        });
    }
}


