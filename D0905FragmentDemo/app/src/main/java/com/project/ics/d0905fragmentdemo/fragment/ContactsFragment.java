package com.project.ics.d0905fragmentdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.ics.d0905fragmentdemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ContactsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contactsLayout=inflater.inflate(R.layout.contacts_layout,container,false);
        return contactsLayout;
    }
}
