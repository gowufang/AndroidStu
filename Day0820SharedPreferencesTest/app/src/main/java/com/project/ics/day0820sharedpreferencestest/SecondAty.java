package com.project.ics.day0820sharedpreferencestest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/20.
 */

public class SecondAty extends Activity{
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readdata);
        textView= (TextView) findViewById(R.id.tv_text);
        button= (Button) findViewById(R.id.btn_read);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
                String myinfo=preferences.getString("myinfo","empty");
                Toast.makeText(SecondAty.this,myinfo,Toast.LENGTH_SHORT).show();
                textView.setText(myinfo);
            }
        });
    }
}
