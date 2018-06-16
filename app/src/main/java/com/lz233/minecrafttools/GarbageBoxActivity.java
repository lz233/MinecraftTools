package com.lz233.minecrafttools;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GarbageBoxActivity extends AppCompatActivity {
    private Button dlucky;
    private Button slucky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage_box);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dlucky = (Button) findViewById(R.id.dlucky);
        slucky = (Button) findViewById(R.id.slucky);
        Buttonlistener buttonlistener = new Buttonlistener();
        dlucky.setOnClickListener(buttonlistener);
        slucky.setOnClickListener(buttonlistener);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //加群上车
                Intent qun = new Intent();
                qun.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + "1iNwfpVqyvb873iwAq2b5fwAW9RLZMQk"));
                try {
                    startActivity(qun);
                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(view, R.string.qq_fail, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }
    public void download(String downloadurl,String filename,String title,View view) {
        int perm = GarbageBoxActivity.this.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        if (perm != PackageManager.PERMISSION_GRANTED) {
            Snackbar.make(view, R.string.no_read_permission, Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadurl));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
        request.setTitle(title);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setMimeType("application/vnd.android.package-archive");
        long id = downloadManager.enqueue(request);
        Snackbar.make(view, R.string.downloading, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
    public void openurl (String url){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private class Buttonlistener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.dlucky){
                download("https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2018/03/31/comandroidvendingbillingInAppBillingServiceCLON_670_3608a6fe-8d9f-5687-8931-082025d63200.apk","Lucky Cracker 6.7.0.apk","Lucky Cracker 6.7.0",view);
            }
            if (view.getId() == R.id.slucky){
                openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2018/03/31/comandroidvendingbillingInAppBillingServiceCLON_670_3608a6fe-8d9f-5687-8931-082025d63200.apk");
            }
        }
    }
}
