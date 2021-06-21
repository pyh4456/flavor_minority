package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddManuActivity extends AppCompatActivity {

    private CheckBox p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12,
            p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24,
            p25, p26, p27, p28 , r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12,
            r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24,
            r25, r26, r27, r28;;
    String bin_result, Restaurant;
    private String token, ID, avoidence, split[]; //MainActivity에서 넘어온 토큰을 저장할 변수
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_manu);
        mContext = this.getApplicationContext();
        Intent intent = getIntent();//넘어온 Intent
        token = intent.getStringExtra("token"); //Intent의 토큰값
        split = token.split(",");
        Restaurant = split[0];
        ID = split[1];
        avoidence = split[2];

        init();
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(mContext.getApplicationContext(), SubActivity.class);
        intent.putExtra("token", "******"+ID+","+avoidence);
        startActivity(intent);

        super.onBackPressed();
//
    }

    private void init() {
        p1 = findViewById(R.id.p_1);    p2 = findViewById(R.id.p_2);
        p3 = findViewById(R.id.p_3);    p4 = findViewById(R.id.p_4);
        p5 = findViewById(R.id.p_5);    p6 = findViewById(R.id.p_6);
        p7 = findViewById(R.id.p_7);    p8 = findViewById(R.id.p_8);
        p9 = findViewById(R.id.p_9);    p10 = findViewById(R.id.p_10);
        p11 = findViewById(R.id.p_11);  p12 = findViewById(R.id.p_12);
        p13 = findViewById(R.id.p_13);  p14 = findViewById(R.id.p_14);
        p15 = findViewById(R.id.p_15);  p16 = findViewById(R.id.p_16);
        p17 = findViewById(R.id.p_17);  p18 = findViewById(R.id.p_18);
        p19 = findViewById(R.id.p_19);  p20 = findViewById(R.id.p_20);
        p21 = findViewById(R.id.p_21);  p22 = findViewById(R.id.p_22);
        p23 = findViewById(R.id.p_23);  p24 = findViewById(R.id.p_24);
        p25 = findViewById(R.id.p_25);  p26 = findViewById(R.id.p_26);
        p27 = findViewById(R.id.p_27);  p28 = findViewById(R.id.p_28);
        r1 = findViewById(R.id.r_1);    r2 = findViewById(R.id.r_2);
        r3 = findViewById(R.id.r_3);    r4 = findViewById(R.id.r_4);
        r5 = findViewById(R.id.r_5);    r6 = findViewById(R.id.r_6);
        r7 = findViewById(R.id.r_7);    r8 = findViewById(R.id.r_8);
        r9 = findViewById(R.id.r_9);    r10 = findViewById(R.id.r_10);
        r11 = findViewById(R.id.r_11);  r12 = findViewById(R.id.r_12);
        r13 = findViewById(R.id.r_13);  r14 = findViewById(R.id.r_14);
        r15 = findViewById(R.id.r_15);  r16 = findViewById(R.id.r_16);
        r17 = findViewById(R.id.r_17);  r18 = findViewById(R.id.r_18);
        r19 = findViewById(R.id.r_19);  r20 = findViewById(R.id.r_20);
        r21 = findViewById(R.id.r_21);  r22 = findViewById(R.id.r_22);
        r23 = findViewById(R.id.r_23);  r24 = findViewById(R.id.r_24);
        r25 = findViewById(R.id.r_25);  r26 = findViewById(R.id.r_26);
        r27 = findViewById(R.id.r_27);  r28 = findViewById(R.id.r_28);
    }

    public void submit_btn2(View view) {
        EditText editText = (EditText)findViewById(R.id.editText);
        String dishName = editText.getText().toString();

        StringBuffer result = new StringBuffer();

        if (r1.isChecked()) result.append("1");
        else result.append("0");
        if (p1.isChecked()) result.append("1");
        else result.append("0");
        if (r2.isChecked()) result.append("1");
        else result.append("0");
        if (p2.isChecked()) result.append("1");
        else result.append("0");
        if (r3.isChecked()) result.append("1");
        else result.append("0");
        if (p3.isChecked()) result.append("1");
        else result.append("0");
        if (r4.isChecked()) result.append("1");
        else result.append("0");
        if (p4.isChecked()) result.append("1");
        else result.append("0");
        if (r5.isChecked()) result.append("1");
        else result.append("0");
        if (p5.isChecked()) result.append("1");
        else result.append("0");
        if (r6.isChecked()) result.append("1");
        else result.append("0");
        if (p6.isChecked()) result.append("1");
        else result.append("0");
        if (r7.isChecked()) result.append("1");
        else result.append("0");
        if (p7.isChecked()) result.append("1");
        else result.append("0");
        if (r8.isChecked()) result.append("1");
        else result.append("0");
        if (p8.isChecked()) result.append("1");
        else result.append("0");
        if (r9.isChecked()) result.append("1");
        else result.append("0");
        if (p9.isChecked()) result.append("1");
        else result.append("0");
        if (r10.isChecked()) result.append("1");
        else result.append("0");
        if (p10.isChecked()) result.append("1");
        else result.append("0");
        if (r11.isChecked()) result.append("1");
        else result.append("0");
        if (p11.isChecked()) result.append("1");
        else result.append("0");
        if (r12.isChecked()) result.append("1");
        else result.append("0");
        if (p12.isChecked()) result.append("1");
        else result.append("0");
        if (r13.isChecked()) result.append("1");
        else result.append("0");
        if (p13.isChecked()) result.append("1");
        else result.append("0");
        if (r14.isChecked()) result.append("1");
        else result.append("0");
        if (p14.isChecked()) result.append("1");
        else result.append("0");
        if (r15.isChecked()) result.append("1");
        else result.append("0");
        if (p15.isChecked()) result.append("1");
        else result.append("0");
        if (r16.isChecked()) result.append("1");
        else result.append("0");
        if (p16.isChecked()) result.append("1");
        else result.append("0");
        if (r17.isChecked()) result.append("1");
        else result.append("0");
        if (p17.isChecked()) result.append("1");
        else result.append("0");
        if (r18.isChecked()) result.append("1");
        else result.append("0");
        if (p18.isChecked()) result.append("1");
        else result.append("0");
        if (r19.isChecked()) result.append("1");
        else result.append("0");
        if (p19.isChecked()) result.append("1");
        else result.append("0");
        if (r20.isChecked()) result.append("1");
        else result.append("0");
        if (p20.isChecked()) result.append("1");
        else result.append("0");
        if (r21.isChecked()) result.append("1");
        else result.append("0");
        if (p21.isChecked()) result.append("1");
        else result.append("0");
        if (r22.isChecked()) result.append("1");
        else result.append("0");
        if (p22.isChecked()) result.append("1");
        else result.append("0");
        if (r23.isChecked()) result.append("1");
        else result.append("0");
        if (p23.isChecked()) result.append("1");
        else result.append("0");
        if (r24.isChecked()) result.append("1");
        else result.append("0");
        if (p24.isChecked()) result.append("1");
        else result.append("0");
        if (r25.isChecked()) result.append("1");
        else result.append("0");
        if (p25.isChecked()) result.append("1");
        else result.append("0");
        if (r26.isChecked()) result.append("1");
        else result.append("0");
        if (p26.isChecked()) result.append("1");
        else result.append("0");
        if (r27.isChecked()) result.append("1");
        else result.append("0");
        if (p27.isChecked()) result.append("1");
        else result.append("0");
        if (r28.isChecked()) result.append("1");
        else result.append("0");
        if (p28.isChecked()) result.append("1");
        else result.append("0");


        bin_result = dishName +","+result.toString();

        DBConnectHelper db = new DBConnectHelper(this);
        db.execute(Restaurant, bin_result);

        finish();
    }
}