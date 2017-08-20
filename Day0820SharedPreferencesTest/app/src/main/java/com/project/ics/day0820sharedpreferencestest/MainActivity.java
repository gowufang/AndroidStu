package com.project.ics.day0820sharedpreferencestest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    String mystring="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.et_edit);

        button= (Button) findViewById(R.id.btn1 );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mystring =editText.getText().toString();//这行不能放在oncreate方法中，因为在活动刚启动的时候执行onCreate方法的时候edittext内容是空的，获取的也将是空值
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("myinfo",mystring);
                editor.commit();
                Intent intent=new Intent(MainActivity.this,SecondAty.class);
                startActivity(intent);
            }
        });
    }
}
