package com.project.ics.day0821databasetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.project.ics.DBUtils.MyDataBaseHelper;

public class MainActivity extends Activity implements View.OnClickListener {

    MyDataBaseHelper dbHelper;
    Button adddata;
    Button updatedata;
    Button deletedata;
    Button querydata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new MyDataBaseHelper(this,"BookStore.db",null,2);
        Button createDatabase= (Button) findViewById(R.id.btn_createbatabase);

        adddata= (Button) findViewById(R.id.add_data);
        adddata.setOnClickListener(this);

        updatedata= (Button) findViewById(R.id.update_data);
        updatedata.setOnClickListener(this);

        deletedata= (Button) findViewById(R.id.delete_data);
        deletedata.setOnClickListener(this);

        querydata= (Button) findViewById(R.id.query_data);
        querydata.setOnClickListener(this);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

//        adddata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();
//                ContentValues values=new ContentValues();
//                values.put("name","The Da Vinci Code");
//                values.put("author","Dan Brown");
//                values.put("pages",500);
//                values.put("price",19.95);
//                sqLiteDatabase.insert("book",null,values);
//                values.clear();
//                values.put("name","The Lost Symbol");
//                values.put("author","Dan Brown");
//                values.put("price",19.3);
//                values.put("pages",300);
//                sqLiteDatabase.insert("book",null,values);
//
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=null;
        switch (v.getId()){

            case R.id.add_data:
                //like java
                db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
                        new String[] { "The Lost Symbol2", "Dan Brown2", "5102", "192.95" });
                //android
//                values=new ContentValues();
//                values.put("name","The Da Vinci Code");
//                values.put("author","Dan Brown");
//                values.put("pages",500);
//                values.put("price",19.95);
//                db.insert("book",null,values);
//                values.clear();
//                values.put("name","The Lost Symbol");
//                values.put("author","Dan Brown");
//                values.put("price",19.3);
//                values.put("pages",300);
//                db.insert("book",null,values);
                break;
            case R.id.update_data:
                values=new ContentValues();
                values.put("price",14.50);
                db.update("book",values,"name=?",new String[]{"The Da Vinci Code"});
                break;
            case R.id.delete_data:
                db.delete("book","pages > ?",new String[] {"450"});
                break;
            case R.id.query_data:

                Cursor cursor= db.query("book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("Mainaty","book name is "+ name);
                        Log.d("Mainaty","book author is "+author);
                        Log.d("Mainaty","book pages is "+pages);
                        Log.d("Mainaty","book price is "+price);
                    }while(cursor.moveToNext());
                    cursor.close();
                }
                break;

            default:
                break;
        }
    }
}
