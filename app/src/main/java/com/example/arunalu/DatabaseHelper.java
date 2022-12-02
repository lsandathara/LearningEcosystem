package com.example.arunalu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //private final Context context;
    SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context, "arunalu.db", null, 1);
        createDb();
    }



    private static final String DATABASE_PATH = "/data/data/com.example.arunalu/databases/arunalu.db";
    private final String USER_TABLE = "user";

    public void createDb(){
        this.getReadableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(username text primary key, password text, fname text, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("drop table if exists user");
    }

    public boolean addUser(String username, String password,String fname, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentVal = new ContentValues();
        contentVal.put("username",username );
        contentVal.put("password",password);
        contentVal.put("fname",fname );
        contentVal.put("email",email);

        long ins = db.insert("user", null,contentVal);

        if(ins == -1)
            return false;
        else
            return true;
    }

    public Boolean checkUsernameAvailability(String un){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username = ?", new String[] {un});

        if(cursor.getCount() >0)
            return false;
        else
            return true;
    }

    private SQLiteDatabase openDatabase(){
        String path = DATABASE_PATH;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public void close(){
        if(db != null){
            db.close();
        }
    }

    //Authenticate with username and password
    public Boolean authenticate(String username,String password){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"username"};
        db = openDatabase();

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(USER_TABLE, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

}
