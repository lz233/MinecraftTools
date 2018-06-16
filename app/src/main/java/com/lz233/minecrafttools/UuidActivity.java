package com.lz233.minecrafttools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class UuidActivity extends AppCompatActivity {
    private WebView uuidweb;
    private Button qun;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uuid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        uuidweb = (WebView) findViewById(R.id.uuidweb);
        qun = (Button)findViewById(R.id.qun);
        uuidweb.loadUrl("file:///android_asset/uuid.html");
        WebSettings webSettings = uuidweb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        qun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //加群上车
                Intent qun = new Intent();
                qun.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + "xkyf_6Ick-8gOn-2Z6KnnskMMSme3fuU"));
                try {
                    startActivity(qun);
                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(view, "打开QQ失败！", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uuidweb.reload();
            }
        });
    }
}
