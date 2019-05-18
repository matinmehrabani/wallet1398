package com.example.wallet1398;


import com.example.wallet1398.data.model.User;

public interface MainInterface {


    interface View {
        void init();

        void setUser(User user);
    }

    interface Presenter {
        void getPassword(String p, String SHA1);
    }

}
