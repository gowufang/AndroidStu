package com.project.ics.d1101listviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> itemList=new ArrayList<>();
    ListView listView;
    public void initItem(){
        for(int i=1;i<40;i++){
            Item item=new Item("name"+i,"10"+i,"1555655554"+i);
            itemList.add(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItem();
        listView= (ListView) findViewById(R.id.list_view);
        ItemAdapter adapter=new ItemAdapter(this,R.layout.item_layout,itemList);
        listView.setAdapter(adapter);
    }
}
