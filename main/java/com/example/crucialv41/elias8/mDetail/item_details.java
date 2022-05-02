package com.example.crucialv41.elias8.mDetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crucialv41.elias8.DatabaseHelper;
import com.example.crucialv41.elias8.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class item_details  extends YouTubeBaseActivity {

    TextView nameTxt;
    TextView descTxt;
    ImageView img;
    Button btnfavorites;
    Button btnOpenLink;
    DatabaseHelper myDB;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    public static final String API_KEY = "AIzaSyDnCRj59Shx1reKqtqsTpo65MKP_0jvS_A";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apps_details);
        overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        myDB = new DatabaseHelper(this);
        String name = getIntent().getExtras().getString("name_key");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(name);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbar.setTitle("");

        //initialize views

        btnfavorites = (Button) findViewById(R.id.favorites);
        btnOpenLink = (Button) findViewById(R.id.button4);
        nameTxt = (TextView) findViewById(R.id.nameTxtdetails);
        img = (ImageView) findViewById(R.id.airdroiddetails);
        descTxt = (TextView) findViewById(R.id.descDetailTxt);
        descTxt.setMovementMethod(new ScrollingMovementMethod());

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_1);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_2);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_3);
        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_4);
        Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_5);
        img.setAnimation(animation1);
        nameTxt.setAnimation(animation2);
        descTxt.setAnimation(animation3);
         btnOpenLink.setAnimation(animation4);
         btnfavorites.setAnimation(animation5);
        //receive data
        Intent i = this.getIntent();
        String desc = i.getExtras().getString("desc_key");
        int image = i.getExtras().getInt("image_key");

        //blind data

        descTxt.setText(desc);
        img.setImageResource(image);


        // opening url
        btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String link = getIntent().getExtras().getString("url_key");
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

            }
        });
        // sending to database
        btnfavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = getIntent().getExtras().getString("name_key");
                    AddData(newEntry);

            }
        });
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube1);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                String youtube = getIntent().getExtras().getString("youtube_key");
                youTubePlayer.loadVideo("wr7Gy7VINB8");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(API_KEY, onInitializedListener);

    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}

