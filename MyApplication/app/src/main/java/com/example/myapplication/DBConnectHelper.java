package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectHelper extends AsyncTask<String, Void, String> {
    AlertDialog dialog;
    Context context;
    public DBConnectHelper(Context context){
        this.context = context;
    }
    @Override
    protected void onPreExecute(){
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("send success");
    }
    @Override
    protected void onPostExecute(String s){
        dialog.setMessage(s);
        dialog.show();
    }
    @Override
    protected String doInBackground(String... str){
        String ID = str[0];
        String bin_result = str[1];
        String result = "";
        String connstr = "";
        if (bin_result.length() < 29) {
            connstr = "http://the4456.iptime.org:8080/jsp/dbsender.jsp";
        } else {
            connstr = "http://the4456.iptime.org:8080/jsp/dbsender2.jsp";
        }

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data = URLEncoder.encode("bin_result","UTF-8")+ "=" +URLEncoder.encode(bin_result, "UTF-8")
            +"&&"+URLEncoder.encode("ID","UTF-8")+ "=" +URLEncoder.encode(ID, "UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while((line = reader.readLine()) != null){
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e){
            result = e.getMessage();
        }
        return result;
    }
}
