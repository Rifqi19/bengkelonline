package com.example.benglelonline.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    public Helper(Context context){
        super(context, "bengkelonline.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, nama text, email text, password text)");
        db.execSQL("CREATE TABLE dataPengeluaran(tanggal INTEGER PRIMARY KEY, keterangan TEXT NULL, nominal TEXT NULL)");
        db.execSQL("INSERT INTO session(id,login) VALUES (1,'kosong')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS dataPengeluaran");
        onCreate(db);
    }

    //Check SESSION
    public Boolean checkSession(String sessionValues){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM session WHERE login = ?", new String[]{sessionValues});
        if (cursor.getCount() > 0 ){
            return true;
        } else {
            return false;
        }
    }

    public Boolean upgradeSession(String sessionValues, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login",sessionValues);
        long update = db.update("session", contentValues,"id="+id, null);
        if (update == -1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean insertUser(String nama, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama",nama);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long insert = db.insert("user", null, contentValues);
        if (insert == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkLogin(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email = ? AND password = ?", new String[]{email,password});
        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }
}
