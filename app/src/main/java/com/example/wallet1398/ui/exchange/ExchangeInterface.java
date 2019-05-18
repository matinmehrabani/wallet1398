package com.example.wallet1398.ui.exchange;

import com.example.wallet1398.data.model.Rates;

import java.util.List;

public interface ExchangeInterface {

    interface View {

        void init();

        void spinner();

        void setRates(List<Rates> list);
    }

    interface Presenter {

        void getRates();
    }


}
