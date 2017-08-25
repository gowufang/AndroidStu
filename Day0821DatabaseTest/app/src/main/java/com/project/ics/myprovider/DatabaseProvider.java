package com.project.ics.myprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.project.ics.DBUtils.MyDataBaseHelper;

/**
 * Created by Administrator on 2017/8/23.
 */

public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR=0;
//    public static final int BOOK_ITEM=1;
    public  static final String AUTHORITY="com.project.ics.databasetest.provider";
    private static UriMatcher uriMatcher;

    private MyDataBaseHelper dbHelper;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);

    }
    @Override
    public boolean onCreate() {
        dbHelper=new MyDataBaseHelper(getContext(),"BookStore.db",null,2);

        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){//get the uri from other application,to judge which table to query

            case BOOK_DIR:
                cursor=db.query("book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.project.ics.day0821databasetest.provider.book";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Uri uriReturn=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                long newBookId=db.insert("book",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/book/"+newBookId);
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        int deletedRows=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deletedRows=db.delete("book",selection,selectionArgs);
                break;
        }
        return deletedRows;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        int updateRows=0;
        switch (uriMatcher.match(uri)){

            case BOOK_DIR:
                updateRows=db.update("book",values,selection,selectionArgs);
                break;
        }
        return updateRows;
    }
}
