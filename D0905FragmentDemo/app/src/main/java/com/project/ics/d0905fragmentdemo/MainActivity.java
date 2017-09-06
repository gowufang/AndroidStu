package com.project.ics.d0905fragmentdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.ics.d0905fragmentdemo.fragment.ContactsFragment;
import com.project.ics.d0905fragmentdemo.fragment.MessageFragment;
import com.project.ics.d0905fragmentdemo.fragment.NewsFragment;

/*
* @author wu*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static Context mContext;
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;

    private View messageLayout;
    private View contactsLayout;
    private View newsLayout;


    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView newsImage;

    private TextView messageText;
    private TextView contactsText;
    private TextView newsText;


    /*
    * 用于对Fragment进行管理
    * */
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();
        fragmentManager=getSupportFragmentManager();
        setTabSelection(0);
    }

    private void initViews() {
        messageLayout=findViewById(R.id.message_layout);
        contactsLayout=findViewById(R.id.contacts_layout);
        newsLayout=findViewById(R.id.news_layout);
        messageImage= (ImageView) findViewById(R.id.message_image);
        contactsImage= (ImageView) findViewById(R.id.contacts_image);
        newsImage= (ImageView) findViewById(R.id.news_image);
        messageText= (TextView) findViewById(R.id.message_text);
        contactsText= (TextView) findViewById(R.id.contacts_text);
        newsText= (TextView) findViewById(R.id.news_text);
        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_layout:
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                setTabSelection(1);
                break;
        }
    }

    private void setTabSelection(int index) {

        clearSelection();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if(messageFragment==null){
                    messageFragment=new MessageFragment();
                    transaction.add(R.id.content,messageFragment);
                }else
                {
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                contactsImage.setImageResource(R.drawable.contacts_selected);
                messageText.setTextColor(Color.WHITE);
                if (contactsFragment==null){
                    contactsFragment=new ContactsFragment();
                    transaction.add(R.id.content,contactsFragment);
                }else{
                    transaction.show(contactsFragment);
                }
                break;
        }
        transaction.commit();

    }
    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));

    }
    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }

    }
}
