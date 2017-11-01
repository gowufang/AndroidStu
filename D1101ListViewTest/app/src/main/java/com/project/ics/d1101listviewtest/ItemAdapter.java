package com.project.ics.d1101listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 * Email:gowufang@gmail.com
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    private int resourceId;

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item=getItem(position);
        Log.d("Getview","getview excuted!"+position);
//        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.name= (TextView) view.findViewById(R.id.name);
            viewHolder.age= (TextView) view.findViewById(R.id.age);
            viewHolder.phone= (TextView) view.findViewById(R.id.phone);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        /*TextView name=(TextView) view.findViewById(R.id.name);
        TextView age= (TextView) view.findViewById(R.id.age);
        TextView phone= (TextView) view.findViewById(R.id.phone);

        name.setText(item.getName());
        age.setText(item.getAge());
        phone.setText(item.getPhone());
        原来每次都需要查找一次控件
        */
        viewHolder.name.setText(item.getName());
        viewHolder.age.setText(item.getAge());
        viewHolder.phone.setText(item.getPhone());

        return view;
    }
    class ViewHolder{
        TextView name;
        TextView age;
        TextView phone;
    }
}
