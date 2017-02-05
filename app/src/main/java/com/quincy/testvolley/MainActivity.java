package com.quincy.testvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private final String TAG = "MainActivity";
    private TextView data;
    private String url = " http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupVolley(url, Request.Method.GET);
    }

    private void init(){
        data = (TextView) findViewById(R.id.data);
        mQueue = Volley.newRequestQueue(MainActivity.this);
    }

    private void setupVolley(String url,int method){
        Log.d(TAG, "setupVolley : ");
        StringRequest request = new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d(TAG, "onResponse s : " + s);
                        data.setText(s);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e(TAG, "onErrorResponse : ", volleyError);
                    }
                }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> map = new HashMap<String, String>();
//                return map;
//            }
        };
        mQueue.add(request);
    }
}
