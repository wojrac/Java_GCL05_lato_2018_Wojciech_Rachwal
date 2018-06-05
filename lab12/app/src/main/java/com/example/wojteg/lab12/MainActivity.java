package com.example.wojteg.lab12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view)
    {

        Intent intent = new Intent(MainActivity.this,WebEntryActivity.class);
        startActivity(intent);
    }
    public void click2(View view)
    {
        Intent intent = new Intent(MainActivity.this,WebEntry2Activity.class);
        startActivity(intent);
    }
    public void click3(View view)
    {

        Intent intent = new Intent(MainActivity.this,Webwithage.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        int age = Integer.parseInt(editText.getText().toString());
        if(age>=18)
        startActivity(intent);
    }
}
