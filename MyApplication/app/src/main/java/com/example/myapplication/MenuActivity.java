package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MenuActivity extends AppCompatActivity {
    public TextView text;
    public String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        text = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        url = intent.getStringExtra("restaurant");

        try{
            url = URLDecoder.decode(url,"UTF-8");
        }catch(UnsupportedEncodingException e){
            url = "url decoder exception";
        }

        text.setText(url.substring(6));
    }
}