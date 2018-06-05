package com.example.wojteg.lab12;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebEntry2Activity extends AppCompatActivity {

    private WebView vebwiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_entry2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vebwiew = new WebView(this);
        vebwiew.getSettings().setJavaScriptEnabled(true);
        final Activity activity = this;
        vebwiew.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public void onReceivedError(WebView view, int errorCode, String description, String fallingurl)
                                     {
                                         super.onReceivedError(view,errorCode,description,fallingurl);
                                         Toast.makeText(activity,description,Toast.LENGTH_LONG).show();
                                     }
                                 }
        );
        vebwiew.loadUrl("http://www.polsatsport.pl");
        setContentView(vebwiew);
    }

}
