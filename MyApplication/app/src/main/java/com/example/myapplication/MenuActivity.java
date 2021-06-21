package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ArrayList<MenuData> menuList;
    private TextView text;
    private String url, restaurant, split[], ID, avoidence;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mContext = this.getApplicationContext();
        text = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        url = intent.getStringExtra("restaurant");
        try {
            url = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            url = "url decoder exception";
        }
        split = url.split(",");
        restaurant = split[0].substring(6);
        ID = split[split.length-2];
        avoidence = split[split.length-1];
        text.setText(restaurant);



        this.InitializeMenuData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final listAdapter adapter = new listAdapter(this,menuList);

        listView.setAdapter(adapter);

        Button settingButton = (Button) findViewById(R.id.button);
        settingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), AddManuActivity.class);
                intent.putExtra("token", restaurant+","+ID+","+avoidence);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(mContext.getApplicationContext(), SubActivity.class);
        intent.putExtra("token", "******"+ID+","+avoidence);
        startActivity(intent);

        super.onBackPressed();
//
    }
    public void InitializeMenuData(){
        menuList = new ArrayList<MenuData>();
        String s[];
        for(int i = 1; i < split.length-2; i++){
            s = split[i].split("&");
            menuList.add(new MenuData(s[0], s[1]));
        }
    }
}