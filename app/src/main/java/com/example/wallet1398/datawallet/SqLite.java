package com.example.wallet1398.datawallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqLite extends SQLiteOpenHelper {

    private static final String TAG = "DataBaseManager";
    private static final String DatabaseName = "myInfo.db";
    private static final int Version = 1;
    private static final String TableName = "tbl_wallet";
    private static final String dSymbol = "symbol";
    private static final String dID = "id";
    private static final String dName = "name";
    private static final String dCode = "code";
    private static final String dType = "type";

    public SqLite(Context context) {
        super(context, DatabaseName, null, Version);
        Log.i(TAG, "DataBaseManager: database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cQuery = "CREATE TABLE " + TableName + " ( " + dID + " integer primary key autoincrement, " + dType + "Text," + dSymbol + "Text," + dName + " TEXT, " + dCode + " TEXT );";
        db.execSQL(cQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertPerson(com.example.wallet1398.data.model.SqLite iprs) {


        SQLiteDatabase idb = this.getWritableDatabase();
        ContentValues icv = new ContentValues();
        icv.put(dName, iprs.wName);
        icv.put(dCode, iprs.wCode);
        idb.insert(TableName, null, icv);
        idb.close();
    }
}
