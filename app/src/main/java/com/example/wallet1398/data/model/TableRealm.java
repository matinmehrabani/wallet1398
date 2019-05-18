package com.example.wallet1398.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TableRealm extends RealmObject {

    @PrimaryKey
   private long id;
   private String name;

    public TableRealm() { }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
