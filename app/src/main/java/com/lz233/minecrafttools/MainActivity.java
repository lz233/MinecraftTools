package com.lz233.minecrafttools;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Random;

import static com.tencent.android.tpush.XGPushManager.registerPush;

public class MainActivity extends AppCompatActivity {
    private TextView onetext;
    private Button tab1_button1;
    private Button tab1_button2;
    private Button tab2_button1;
    private Button tab3_botton1;
    private Button tab4_botton1;
    private CardView devcard;
    private Button devcard_webview;
    private final int REQUEST_EXTERNAL_STORAGE = 1;
    private String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bugly.init(getApplicationContext(), "73e75fdecb", false);
        XGPushManager.registerPush(this);
        XGPushManager.registerPush(this, "04");
        XGPushManager.setTag(this,"200");
        XGPushConfig.getToken(this);
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
        onetext = (TextView) findViewById(R.id.onetext);
        devcard = (CardView) findViewById(R.id.devcard);
        devcard_webview = (Button) findViewById(R.id.devcard_webview);
        tab1_button1 = (Button) findViewById(R.id.tab1_button1);
        tab1_button2 = (Button) findViewById(R.id.tab1_button2);
        tab2_button1 = (Button) findViewById(R.id.tab2_button1);
        tab3_botton1 = (Button) findViewById(R.id.tab3_button1);
        tab4_botton1 = (Button) findViewById(R.id.tab4_button1);
        Bottonlistener bottonlistener = new Bottonlistener();
        devcard_webview.setOnClickListener(bottonlistener);
        tab1_button1.setOnClickListener(bottonlistener);
        tab1_button2.setOnClickListener(bottonlistener);
        tab2_button1.setOnClickListener(bottonlistener);
        tab3_botton1.setOnClickListener(bottonlistener);
        tab4_botton1.setOnClickListener(bottonlistener);

        Modus modus = new Modus();
        if(modus.getkeytime()<=0){
            devcard.setVisibility(View.GONE);
        }
        Locale mSystemLanguageList[]= Locale.getAvailableLocales();
        String lan =Locale.getDefault().getLanguage();
        //Toast.makeText(MainActivity.this, lan, Toast.LENGTH_LONG).show();
        if(lan.equals("zh")){
            InputStream inputStream = null;
            try {
                inputStream = getAssets().open("onetext.json");
                int size = inputStream.available();
                int len = -1;
                byte[] bytes = new byte[size];
                inputStream.read(bytes);
                inputStream.close();
                String onetexting = new String(bytes);
                JSONObject jsonObject = new JSONObject(onetexting);
                int random = new Random().nextInt(jsonObject.optInt("latest")+1);
                onetext.setText(jsonObject.optString(String.valueOf(random)));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_LONG).show();
            }
        }else {
            onetext.setVisibility(View.GONE);
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class Bottonlistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.devcard_webview){
                final EditText editText = new EditText(MainActivity.this);
                editText.setText("http://");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("请输入网址")
                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, URLActivity.class);
                                intent.putExtra("URL",editText.getText().toString());
                                intent.putExtra("name","test");
                                startActivity(intent);
                            }
                        })
                        .show();

            }
            if (view.getId() == R.id.tab1_button1){
                Intent intent = new Intent(MainActivity.this, MinecraftDownloadActivity.class);
                startActivity(intent);
            }
            if (view.getId() == R.id.tab1_button2){
                Intent intent = new Intent(MainActivity.this, MinecraftDownload2Activity.class);
                startActivity(intent);
            }
            if (view.getId() == R.id.tab2_button1){
                Intent intent = new Intent(MainActivity.this, GarbageBoxActivity.class);
                startActivity(intent);
            }
            if (view.getId() == R.id.tab3_button1){
                Intent intent = new Intent(MainActivity.this, UuidActivity.class);
                startActivity(intent);
            }
            if (view.getId() == R.id.tab4_button1){
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        }
    }
}
