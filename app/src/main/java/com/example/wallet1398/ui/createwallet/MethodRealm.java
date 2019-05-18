package com.example.wallet1398.ui.createwallet;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.wallet1398.R;
import com.example.wallet1398.data.model.TableRealm;

import io.realm.Realm;
import io.realm.RealmResults;

public class MethodRealm {
    Realm realm;

    public MethodRealm() {
        realm = Realm.getDefaultInstance();
    }

    public void saveData(final Context context, final String name) {
        realm.executeTransactionAsync(new Realm.Transaction() {
                                          @Override
                                          public void execute(Realm realm) {
                                              long mid;
                                              Number number = realm.where(TableRealm.class).max("id");
                                              if (number == null) {
                                                  mid = 1;
                                              } else {
                                                  mid = number.longValue() + 1;
                                              }
                                              TableRealm modelRealms = realm.createObject(TableRealm.class, mid);
                                              modelRealms.setName(name);
                                          }

                                      },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(context, R.string.Success, Toast.LENGTH_SHORT).show();
                    }
                },
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Toast.makeText(context, R.string.Error, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void showData() {
        RealmResults<TableRealm> results = realm.where(TableRealm.class).findAll();
        for (TableRealm ud : results) {
            Log.i("show data", "showdata: " + results.toString());
        }

    }
}
