package com.example.crucialv41.elias8.android;

import android.opengl.Visibility;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.example.crucialv41.elias8.R;
import com.example.crucialv41.elias8.android.mDataandroid.apps_collection_anonymous;
import com.example.crucialv41.elias8.android.mListviewandroid.adapter_anonymous;
import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;

public class anonymous extends AppCompatActivity {
    SearchView sv;
    Button buttonDelete;
    com.example.crucialv41.elias8.android.mListviewandroid.adapter_anonymous adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_anonymous);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ExpandableHeightListView lv = (ExpandableHeightListView) findViewById(R.id.lv_anonymous);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ANONYMOUS");
        sv= (SearchView) findViewById(R.id.mSearch);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbar.setTitle("");

        adapter=new  adapter_anonymous(this, apps_collection_anonymous.getapps());
        lv.setTextFilterEnabled(true);
        lv.setAdapter(adapter);
        lv.setExpanded(true);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fld);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sv.setVisibility(View.VISIBLE);
                Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_4);
                sv.setAnimation(animation4);
                // show the searchbox and bla bla...
            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
