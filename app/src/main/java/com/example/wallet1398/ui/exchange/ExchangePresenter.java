package com.example.wallet1398.ui.exchange;

import com.example.wallet1398.data.model.Rates;
import com.example.wallet1398.datawallet.Retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExchangePresenter implements ExchangeInterface.Presenter {
    private List<Rates> list;
    private ExchangeInterface.View view;

    public ExchangePresenter(ExchangeInterface.View view) {
        this.view = view;
    }

    @Override
    public void getRates() {
        Retrofit.getApi().getListrates().enqueue(new Callback<List<Rates>>() {
            @Override
            public void onResponse(Call<List<Rates>> call, Response<List<Rates>> response) {
                list = new ArrayList<>();
                list = response.body();
                view.setRates(list);



            }

            @Override
            public void onFailure(Call<List<Rates>> call, Throwable t) {

            }
        });
    }
}
