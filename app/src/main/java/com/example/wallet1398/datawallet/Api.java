package com.example.wallet1398.datawallet;

import com.example.wallet1398.data.model.Confirmation;
import com.example.wallet1398.data.model.Currencies;
import com.example.wallet1398.data.model.Rates;
import com.example.wallet1398.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;

public interface Api {

    @FormUrlEncoded
    @HTTP(method = "CLAIM", path = "/apiv1/clients", hasBody = true)
    Call<User> getPassword(@Field("phone") String phone, @Field("udid") String udid);

    @FormUrlEncoded
    @HTTP(method = "BIND", path = "/apiv1/clients", hasBody = true)
    Call<Confirmation> confirmation(@Field("phone") String phone, @Field("udid") String udid,
                                    @Field("deviceName") String devicename, @Field("activationCode")
                                            String activationcode);

    @HTTP(method = "LIST", path = "/apiv1/currencies")
    Call<List<Currencies>> getList();

    @HTTP(method = "LIST", path = "/apiv1/rates")
    Call<List<Rates>> getListrates();
}
