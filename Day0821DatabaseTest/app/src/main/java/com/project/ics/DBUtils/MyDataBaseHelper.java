package com.project.ics.DBUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/8/21.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {//use to create or update

    public static final String CREATE_BOOK="create table book("//Should be Upcase??
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text)";

    public static final String CREATE_CATEGORY="create table Category("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";
    private Context mContext;


    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);//second param is the name of the db
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//create the database,located on /data/data/<package name>/databases/

        db.execSQL(CREATE_BOOK);//create the table
        db.execSQL(CREATE_CATEGORY);
//        Toast.makeText(mContext,"Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
