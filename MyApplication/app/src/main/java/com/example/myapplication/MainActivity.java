package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private WebView mWebView; // 웹뷰 선언
    private WebSettings mWebSettings; //웹뷰세팅
    private com.example.myapplication.GpsTracker gpsTracker;
    private Context mContext;
    private int backButtonPressed = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebSettings = mWebView.getSettings(); //세부 세팅 등록
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        //mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        //7mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        //mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
        //mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("http://the4456.iptime.org:8080/jsp/login.jsp"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작

        mContext = this.getApplicationContext();
        mWebView.setWebViewClient(new WebViewClientClass());

    }
    private class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            if(url.startsWith("app://")){
                Intent intent = new Intent(mContext.getApplicationContext(), SubActivity.class);
                intent.putExtra("token", url);
                startActivity(intent);
                finish();
                return true;
            }
            else{
                view.loadUrl(url);
                return true;
            }
        }
    }
    @Override
    public void onBackPressed() {
        if(backButtonPressed == 1){
            super.onBackPressed();
        }else{
            Toast.makeText(MainActivity.this, "앱을 종료하려면 뒤로가기버튼을 한번 더 누르세요", Toast.LENGTH_SHORT).show();
            backButtonPressed++;
        }
    }

}

