package com.example.crucialv41.elias8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
 CircleImageView circleimage;
    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       circleimage=(CircleImageView)findViewById(R.id.profile_image);
        Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_6);
        circleimage.setAnimation(animation6);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText("");

        final long period = 20;
        //this repeats every 20 ms
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(i)+"%");
                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }else{
                    //closing the timer
                    timer.cancel();
                    Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_out_up, R.anim.slide_in_up);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);





    }

}
