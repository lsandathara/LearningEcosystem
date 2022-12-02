package com.example.arunalu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "arunalu.db";

    public static final String TABLE_NAME_1 = "user";
    public static final String USER_NAME = "userName";
    public static final String FIRST_NAME = "fName";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PICTURE = "picture";

    public static final String TABLE_NAME_2 = "subUser";
    public static final String PARENT_NAME = "parentName";
    public static final String SUB_USER_NAME = "subUserName";
    public static final String F_NAME = "fName";
    public static final String PIC = "picture";
    public static final String GENDER = "gender";
    public static final String AGE = "age";
    public static final String REPORT = "report";

    public static final String TABLE_NAME_3 = "method";
    public static final String METHOD_ID = "mId";
    public static final String METHOD_NAME = "method";

    public static final String TABLE_NAME_4 = "data";
    public static final String SUB_USER_ID = "subUser";
    public static final String TRY_OUT_ID = "tryOutId";
    public static final String METHOD = "mId";
    public static final String WORDS = "words";
    public static final String TIME = "time";
    public static final String RECORDING = "recording";

    public static final String TABLE_NAME_5 = "question";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME_1+" ("+USER_NAME+" TEXT PRIMARY KEY,"+FIRST_NAME+" TEXT, "+EMAIL+" TEXT, "+PASSWORD+" TEXT, "+PICTURE+" BLOB)");

        db.execSQL("create table "+TABLE_NAME_2+" ("+PARENT_NAME+" TEXT,"+SUB_USER_NAME+" TEXT PRIMARY KEY, "+F_NAME+" TEXT, "+GENDER+" TEXT, "+PIC+" BLOB,"+AGE+" INTEGER, "+REPORT+" BLOB, " +
                "    CONSTRAINT fk_parent_user\n" +
                "    FOREIGN KEY ("+PARENT_NAME+")\n" +
                "    REFERENCES "+TABLE_NAME_1+"("+USER_NAME+"))");

        db.execSQL("create table "+TABLE_NAME_3+" ("+METHOD_ID+" TEXT PRIMARY KEY,"+METHOD_NAME+" TEXT)");

        db.execSQL("create table "+TABLE_NAME_4+" ("+SUB_USER_ID+" TEXT,"+TRY_OUT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+METHOD+" TEXT, "+WORDS+" TEXT, "+TIME+" TEXT, "+RECORDING+" BLOB, " +
                "    CONSTRAINT fk_sub_user\n" +
                "    FOREIGN KEY ("+SUB_USER_ID+")\n" +
                "    REFERENCES "+TABLE_NAME_2+"("+SUB_USER_NAME+")," +
                "    CONSTRAINT fk_method\n" +
                "    FOREIGN KEY ("+METHOD+")\n" +
                "    REFERENCES "+TABLE_NAME_3+"("+METHOD_ID+"))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_3);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_4);
        onCreate(sqLiteDatabase);
    }

    public  boolean insertData(String parentId, String userId, String firstName, String gender, Blob profilePic, Integer age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PARENT_NAME, parentId);
        contentValues.put(SUB_USER_NAME, userId);
        contentValues.put(F_NAME, firstName);
        contentValues.put(PIC, String.valueOf(profilePic));
        contentValues.put(GENDER, gender);
        contentValues.put(AGE, age);

        long result = db.insert(TABLE_NAME_2, null, contentValues);

        if (result == -1)
            return  false;
        else
            return true;
    }
}
