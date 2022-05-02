package com.example.crucialv41.elias8.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.example.crucialv41.elias8.R;

public class ddosattack extends AppCompatActivity {
    Button buttonDelete;
    com.example.crucialv41.elias8.android.mListviewandroid.adapter_ddos adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_ddosattack);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ListView lv=(ListView) findViewById(R.id.lv_ddosattack);
        adapter=new  com.example.crucialv41.elias8.android.mListviewandroid.adapter_ddos(this, com.example.crucialv41.elias8.android.mDataandroid.apps_collection_ddos.getapps());
        lv.setTextFilterEnabled(true);
        lv.setAdapter(adapter);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}