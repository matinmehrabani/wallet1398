package com.example.wallet1398.ui.login;

import com.example.wallet1398.data.model.Confirmation;

public interface LoginInterface {

    interface View {

        void init();

        void setConfirmation(Confirmation confirmation);

        void snackBar();
    }

    interface Presenter {

        void bind(String phone, String uDid, String model, String password);

    }
}
