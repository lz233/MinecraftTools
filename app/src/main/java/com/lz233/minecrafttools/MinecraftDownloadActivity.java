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

public class MinecraftDownloadActivity extends AppCompatActivity {
    private Button dv0141;
    private Button sv0141;
    private Button dv01540;
    private Button sv01540;
    private Button dv01622;
    private Button sv01622;
    private Button dv10016;
    private Button sv10016;
    private Button dv1091;
    private Button sv1091;
    private Button dv1151;
    private Button sv1151;
    private Button dv12101;
    private Button sv12101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minecraft_download);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dv0141 = (Button) findViewById(R.id.dv0141);
        sv0141 = (Button) findViewById(R.id.sv0141);
        dv01540 = (Button) findViewById(R.id.dv01540);
        sv01540 = (Button) findViewById(R.id.sv01540);
        dv01622 = (Button) findViewById(R.id.dv01622);
        sv01622 = (Button) findViewById(R.id.sv01622);
        dv10016 = (Button) findViewById(R.id.dv10016);
        sv10016 = (Button) findViewById(R.id.sv10016);
        dv1091 = (Button) findViewById(R.id.dv1091);
        sv1091 = (Button) findViewById(R.id.sv1091);
        dv1151 = (Button) findViewById(R.id.dv1151);
        sv1151 = (Button) findViewById(R.id.sv1151);
        dv12101 = (Button) findViewById(R.id.dv12101);
        sv12101 = (Button) findViewById(R.id.sv12101);

        Buttonlistener buttonlistener = new Buttonlistener();
        dv0141.setOnClickListener(buttonlistener);
        sv0141.setOnClickListener(buttonlistener);
        dv01540.setOnClickListener(buttonlistener);
        sv01540.setOnClickListener(buttonlistener);
        dv01622.setOnClickListener(buttonlistener);
        sv01622.setOnClickListener(buttonlistener);
        dv10016.setOnClickListener(buttonlistener);
        sv10016.setOnClickListener(buttonlistener);
        dv1091.setOnClickListener(buttonlistener);
        sv1091.setOnClickListener(buttonlistener);
        dv1151.setOnClickListener(buttonlistener);
        sv1151.setOnClickListener(buttonlistener);
        dv12101.setOnClickListener(buttonlistener);
        sv12101.setOnClickListener(buttonlistener);
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
        int perm = MinecraftDownloadActivity.this.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
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
                if (view.getId() == R.id.dv0141) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_0141_8c63bf4f-4d13-528c-b475-6b6a93884db9.apk", "Minecraft 0.14.1.apk", "Minecraft 0.14.1",view);
                }
                if (view.getId() == R.id.sv0141) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_0141_8c63bf4f-4d13-528c-b475-6b6a93884db9.apk");
                }
                if (view.getId() == R.id.dv01540) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_01540_0864f2ff-683c-5e9d-9928-612d25e3047c.apk", "Minecraft 0.15.4.0.apk", "Minecraft 0.15.4.0",view);
                }
                if (view.getId() == R.id.sv01540) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_01540_0864f2ff-683c-5e9d-9928-612d25e3047c.apk");
                }
                if (view.getId() == R.id.dv01622) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_01622_92ef4b23-ef68-5a97-9799-baf0f27540f0.apk", "Minecraft 0.16.2.2.apk", "Minecraft 0.16.2.2",view);
                }
                if (view.getId() == R.id.sv01622) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_01622_92ef4b23-ef68-5a97-9799-baf0f27540f0.apk");
                }
                if (view.getId() == R.id.dv10016) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_10016_53219a80-a6ec-5c9e-af37-7f038c9a7873.apk", "Minecraft 1.0.0.16.apk", "Minecraft 1.0.0.16",view);
                }
                if (view.getId() == R.id.sv10016) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_10016_53219a80-a6ec-5c9e-af37-7f038c9a7873.apk");
                }
                if (view.getId() == R.id.dv1091) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_1091_23a8eb88-a225-5083-a78e-4e53f0e17142.apk", "Minecraft 1.0.9.1.apk", "Minecraft 1.0.9.1",view);
                }
                if (view.getId() == R.id.sv1091) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_1091_23a8eb88-a225-5083-a78e-4e53f0e17142.apk");
                }
                if (view.getId() == R.id.dv1151) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_1151_05e440b1-d14f-522a-a991-6662fac7c236.apk", "Minecraft 1.1.5.1.apk", "Minecraft 1.1.5.1",view);
                }
                if (view.getId() == R.id.sv1151) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file/commojangminecraftpe_1151_05e440b1-d14f-522a-a991-6662fac7c236.apk");
                }
                if (view.getId() == R.id.dv12101) {
                    download("https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2018/03/31/commojangminecraftpe_12101_cdee86cc-cdd9-54b3-a86c-8f6894b9f8ce.apk", "Minecraft 1.2.10.1.apk", "Minecraft 1.2.10.1",view);
                }
                if (view.getId() == R.id.sv12101) {
                    openurl("https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2018/03/31/commojangminecraftpe_12101_cdee86cc-cdd9-54b3-a86c-8f6894b9f8ce.apk");
                }
        }
    }
}
