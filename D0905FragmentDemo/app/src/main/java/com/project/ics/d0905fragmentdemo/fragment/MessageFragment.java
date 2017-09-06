package com.project.ics.d0905fragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.project.ics.d0905fragmentdemo.MyApplication;
import com.project.ics.d0905fragmentdemo.R;

/**
 * Created by Administrator on 217/9/5.
 */

public class MessageFragment extends Fragment {

    LinearLayout showMessageLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View messageLayout=inflater.inflate(R.layout.message_layout,container,false);
        showMessageLayout= (LinearLayout) messageLayout.findViewById(R.id.show_message);
        showMessageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(),"clicked",Toast.LENGTH_SHORT).show();
            }
        });
        return messageLayout;
    }
}
