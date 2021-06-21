package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//Subactivity에서 setting버튼으로 넘어오는 액티비티
public class SubActivity2 extends AppCompatActivity {

    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12,
            ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24,
            ch25, ch26, ch27, ch28;
    private Button btn_submit;
    String bin_result;
    private String token, ID, avoidence, split[]; //SubActivity에서 넘어온 토큰을 저장할 변수
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_main2);
        mContext = this.getApplicationContext();
        Intent intent = getIntent();//넘어온 Intent
        token = intent.getStringExtra("token"); //Intent의 토큰값

        String split[] = token.split(",");
        ID = split[0];
        avoidence = split[1];

        init();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(mContext.getApplicationContext(), SubActivity.class);
        intent.putExtra("token", "******"+token);
        startActivity(intent);

        super.onBackPressed();
//
    }
    private void init() {
        ch1 = findViewById(R.id.f_1);   ch1.setChecked(avoidence.charAt(0)=='1' ? true: false);
        ch2 = findViewById(R.id.f_2);   ch2.setChecked(avoidence.charAt(1)=='1' ? true: false);
        ch3 = findViewById(R.id.f_3);   ch3.setChecked(avoidence.charAt(2)=='1' ? true: false);
        ch4 = findViewById(R.id.f_4);   ch4.setChecked(avoidence.charAt(3)=='1' ? true: false);
        ch5 = findViewById(R.id.f_5);   ch5.setChecked(avoidence.charAt(4)=='1' ? true: false);
        ch6 = findViewById(R.id.f_6);   ch6.setChecked(avoidence.charAt(5)=='1' ? true: false);
        ch7 = findViewById(R.id.f_7);   ch7.setChecked(avoidence.charAt(6)=='1' ? true: false);
        ch8 = findViewById(R.id.f_8);   ch8.setChecked(avoidence.charAt(7)=='1' ? true: false);
        ch9 = findViewById(R.id.f_9);   ch9.setChecked(avoidence.charAt(8)=='1' ? true: false);
        ch10 = findViewById(R.id.f_10); ch10.setChecked(avoidence.charAt(9)=='1' ? true: false);
        ch11 = findViewById(R.id.f_11); ch11.setChecked(avoidence.charAt(10)=='1' ? true: false);
        ch12 = findViewById(R.id.f_12); ch12.setChecked(avoidence.charAt(11)=='1' ? true: false);
        ch13 = findViewById(R.id.f_13); ch13.setChecked(avoidence.charAt(12)=='1' ? true: false);
        ch14 = findViewById(R.id.f_14); ch14.setChecked(avoidence.charAt(13)=='1' ? true: false);
        ch15 = findViewById(R.id.f_15); ch15.setChecked(avoidence.charAt(14)=='1' ? true: false);
        ch16 = findViewById(R.id.f_16); ch16.setChecked(avoidence.charAt(15)=='1' ? true: false);
        ch17 = findViewById(R.id.f_17); ch17.setChecked(avoidence.charAt(16)=='1' ? true: false);
        ch18 = findViewById(R.id.f_18); ch18.setChecked(avoidence.charAt(17)=='1' ? true: false);
        ch19 = findViewById(R.id.f_19); ch19.setChecked(avoidence.charAt(18)=='1' ? true: false);
        ch20 = findViewById(R.id.f_20); ch20.setChecked(avoidence.charAt(19)=='1' ? true: false);
        ch21 = findViewById(R.id.f_21); ch21.setChecked(avoidence.charAt(20)=='1' ? true: false);
        ch22 = findViewById(R.id.f_22); ch22.setChecked(avoidence.charAt(21)=='1' ? true: false);
        ch23 = findViewById(R.id.f_23); ch23.setChecked(avoidence.charAt(22)=='1' ? true: false);
        ch24 = findViewById(R.id.f_24); ch24.setChecked(avoidence.charAt(23)=='1' ? true: false);
        ch25 = findViewById(R.id.f_25); ch25.setChecked(avoidence.charAt(24)=='1' ? true: false);
        ch26 = findViewById(R.id.f_26); ch26.setChecked(avoidence.charAt(25)=='1' ? true: false);
        ch27 = findViewById(R.id.f_27); ch27.setChecked(avoidence.charAt(26)=='1' ? true: false);
        ch28 = findViewById(R.id.f_28); ch28.setChecked(avoidence.charAt(27)=='1' ? true: false);
    }

    public void submit_btn(View view) {
        StringBuffer result = new StringBuffer();

        if (ch1.isChecked()) result.append("1");
        else result.append("0");
        if (ch2.isChecked()) result.append("1");
        else result.append("0");
        if (ch3.isChecked()) result.append("1");
        else result.append("0");
        if (ch4.isChecked()) result.append("1");
        else result.append("0");
        if (ch5.isChecked()) result.append("1");
        else result.append("0");
        if (ch6.isChecked()) result.append("1");
        else result.append("0");
        if (ch7.isChecked()) result.append("1");
        else result.append("0");
        if (ch8.isChecked()) result.append("1");
        else result.append("0");
        if (ch9.isChecked()) result.append("1");
        else result.append("0");
        if (ch10.isChecked()) result.append("1");
        else result.append("0");
        if (ch11.isChecked()) result.append("1");
        else result.append("0");
        if (ch12.isChecked()) result.append("1");
        else result.append("0");
        if (ch13.isChecked()) result.append("1");
        else result.append("0");
        if (ch14.isChecked()) result.append("1");
        else result.append("0");
        if (ch15.isChecked()) result.append("1");
        else result.append("0");
        if (ch16.isChecked()) result.append("1");
        else result.append("0");
        if (ch17.isChecked()) result.append("1");
        else result.append("0");
        if (ch18.isChecked()) result.append("1");
        else result.append("0");
        if (ch19.isChecked()) result.append("1");
        else result.append("0");
        if (ch20.isChecked()) result.append("1");
        else result.append("0");
        if (ch21.isChecked()) result.append("1");
        else result.append("0");
        if (ch22.isChecked()) result.append("1");
        else result.append("0");
        if (ch23.isChecked()) result.append("1");
        else result.append("0");
        if (ch24.isChecked()) result.append("1");
        else result.append("0");
        if (ch25.isChecked()) result.append("1");
        else result.append("0");
        if (ch26.isChecked()) result.append("1");
        else result.append("0");
        if (ch27.isChecked()) result.append("1");
        else result.append("0");
        if (ch28.isChecked()) result.append("1");
        else result.append("0");

        bin_result = result.toString();

        //Toast.makeText(getApplicationContext(), ID , Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), bin_result , Toast.LENGTH_SHORT).show();

        DBConnectHelper db = new DBConnectHelper(this);
        db.execute(ID, bin_result);

        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("token", "111111"+ID+","+bin_result);
        startActivity(intent);
        finish();
    }
}
