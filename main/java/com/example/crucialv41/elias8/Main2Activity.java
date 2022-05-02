package com.example.crucialv41.elias8;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Intent a;
    Intent b;
    Intent c;
    Intent d;
    Typeface myfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
myfont.createFromAsset(getAssets(),"fonts/BankGothic Bold.ttf");

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button btn = (Button) findViewById(R.id.tools);
        btn.setTypeface(myfont);
        a = new Intent(this, tools.class);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button btn1 = (Button) findViewById(R.id.favorites);
        btn1.setTypeface(myfont);
        b = new Intent(this, favorites.class);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(b);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        Button btn2 = (Button) findViewById(R.id.settings);
        btn2.setTypeface(myfont);
        c = new Intent(this, settings.class);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(c);
                overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up);
            }
        });
        Button btn3 = (Button) findViewById(R.id.about);
        btn3.setTypeface(myfont);
        d = new Intent(this, about.class);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(d);
                overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up);
            }
        });
    }

}