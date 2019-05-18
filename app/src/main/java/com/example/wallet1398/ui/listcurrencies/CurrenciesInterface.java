package com.example.wallet1398.ui.listcurrencies;

import com.example.wallet1398.data.model.Currencies;

import java.util.List;

public interface CurrenciesInterface {

    interface View {
        void init();

        void setCurrencies(List<Currencies> list);
    }

    interface Presenter {

        void getCurrencies();
    }


}
