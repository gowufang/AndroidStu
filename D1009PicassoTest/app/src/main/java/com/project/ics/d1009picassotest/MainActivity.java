package com.project.ics.d1009picassotest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private static final String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507563671278&di=090fc6e4d17748aaebfeab08f48eb11f&imgtype=0&src=http%3A%2F%2Fv1.qzone.cc%2Favatar%2F201310%2F12%2F15%2F42%2F5258fd6f0db4b914.jpg%2521200x200.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(Uri.parse(imageUrl)).fit().into(imageView);
//        Picasso.with(this).load(imageUrl).into(imageView);


    }
}
