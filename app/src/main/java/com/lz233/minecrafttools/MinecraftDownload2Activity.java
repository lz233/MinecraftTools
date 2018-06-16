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

public class MinecraftDownload2Activity extends AppCompatActivity {
    private Button dv01540_win;
    private Button sv01540_win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft_download2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dv01540_win = (Button) findViewById(R.id.dv01540_win);
        sv01540_win = (Button) findViewById(R.id.sv01540_win);
        Buttonlistener buttonlister = new Buttonlistener();
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
        int perm = MinecraftDownload2Activity.this.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
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
            int perm = MinecraftDownload2Activity.this.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            if (perm != PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(view, R.string.no_read_permission, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }else {
                if (view.getId() == R.id.dv01540_win) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_01540_91cd392b-48f9-54ee-87ae-c30e387e229c.apk", "Minecraft 0.15.4.0 Win10UI.apk", "Minecraft 0.15.4.0 Win10UI",view);
                }
                if (view.getId() == R.id.sv01540_win) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_01540_91cd392b-48f9-54ee-87ae-c30e387e229c.apk");
                }
            }
        }
    }
}
