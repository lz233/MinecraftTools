package com.lz233.minecrafttools;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushTextMessage;

import static android.view.KeyEvent.KEYCODE_BACK;

public class URLActivity extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        Intent URL = getIntent();
        URL.getStringExtra("URL");

        final WebView web = (WebView) findViewById(R.id.web);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        web.loadUrl(URL.getStringExtra("URL"));
        web.canGoBack();
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //webSettings.setAllowFileAccess(true);
        //webSettings.setLoadsImagesAutomatically(true);
        //web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.setDownloadListener(new WebViewDownLoadListener());
        web.onResume();

        web.setWebViewClient(new WebViewClient() {
            @Override
            //在自身打开网页
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //处理https响应
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();    //表示等待证书响应
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView web = (WebView) findViewById(R.id.web);
        if ((keyCode == KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewDownLoadListener implements DownloadListener {
        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            int perm = URLActivity.this.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            if (perm != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(URLActivity.this, R.string.no_read_permission, Toast.LENGTH_LONG).show();
            } else {
                Uri uri = Uri.parse(url);
                Intent name = getIntent();
                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(String.valueOf(uri)));
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name.getStringExtra("name") + ".apk");
                request.setTitle(name.getStringExtra("name"));
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setMimeType("application/vnd.android.package-archive");
                long downloadId = downloadManager.enqueue(request);
                Toast.makeText(URLActivity.this, R.string.downloading, Toast.LENGTH_LONG).show();
            }
        }
    }
}
