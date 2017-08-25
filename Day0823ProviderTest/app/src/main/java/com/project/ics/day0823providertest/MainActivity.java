package com.project.ics.day0823providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String newId=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addData= (Button) findViewById(R.id.add_data);
        Button queryData= (Button) findViewById(R.id.query_data);
        Button updateData= (Button) findViewById(R.id.update_data);
        Button deleteData= (Button) findViewById(R.id.delete_book);
        addData.setOnClickListener(this);
        queryData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Uri uri;
        switch (v.getId()){
            case R.id.add_data:
                 uri=Uri.parse("content://com.project.ics.day0821databasetest.provider/book");
                ContentValues values=new ContentValues();
                values.put("name","A Clash of Kings");
                values.put("author","George Martin");
                values.put("pages",1024);
                values.put("price",22.55);
                Uri newUri=getContentResolver().insert(uri,values);
                newId=newUri.getPathSegments().get(1);//get the id,it will be used later
                break;
            case R.id.query_data:
                uri =Uri.parse("content://com.project.ics.day0821databasetest.provider/book");

                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor!=null){

                    while(cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        String pages=cursor.getString(cursor.getColumnIndex("pages"));
                        String price=cursor.getString(cursor.getColumnIndex("price"));
                        Log.d("MainActivity","booke name is"+name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    }
                    cursor.close();
                }
        }
    }
}
