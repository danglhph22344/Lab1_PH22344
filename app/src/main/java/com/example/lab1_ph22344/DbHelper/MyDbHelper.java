package com.example.lab1_ph22344.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SalesManagement.db";
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCatTable = "CREATE TABLE tb_cat (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        String createProductTable = "CREATE TABLE tb_product (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price REAL, id_cat INTEGER, FOREIGN KEY (id_cat) REFERENCES tb_cat(id))";
        db.execSQL(createCatTable);
        db.execSQL(createProductTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_cat");
        db.execSQL("DROP TABLE IF EXISTS tb_product");
        onCreate(db);
    }
}
