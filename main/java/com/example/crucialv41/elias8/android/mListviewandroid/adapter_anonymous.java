package com.example.crucialv41.elias8.android.mListviewandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crucialv41.elias8.CustomFilter;
import com.example.crucialv41.elias8.R;
import com.example.crucialv41.elias8.android.mDataandroid.apps_anonymous;
import com.example.crucialv41.elias8.mDetail.item_details;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;


public class adapter_anonymous extends BaseAdapter implements Filterable {
    Context c;
    public ArrayList<apps_anonymous> appss;
    ArrayList<apps_anonymous> filterList;
    CustomFilter filter;
    LayoutInflater inflater;

    public adapter_anonymous(Context c, ArrayList<apps_anonymous> appss) {
        this.c = c;
        this.appss = appss;
        this.filterList = appss;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return appss.size();
    }

    @Override
    public Object getItem(int position) {
        return appss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model, parent, false);

        }
        TextView nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
        TextView urlTxt = (TextView) convertView.findViewById(R.id.url);
        TextView descTxt = (TextView) convertView.findViewById(R.id.descTxt);
        ImageView img = (ImageView) convertView.findViewById(R.id.airdroid);
        SimpleRatingBar ratingBar = (SimpleRatingBar) convertView.findViewById(R.id.ratingBarID);
        TextView txtyoutube = (TextView) convertView.findViewById(R.id.youtube);

        final String name = appss.get(position).getName();
        final String desc = appss.get(position).getDesc();
        final String url = appss.get(position).getUrl();
        final int image = appss.get(position).getImage();
        final String youtube = appss.get(position).getyoutube();
        final int rating = appss.get(position).getRating();

        ratingBar.setFocusable(false);
        ratingBar.setClickable(false);
        //bind data
        nameTxt.setText(name);
        urlTxt.setText(url);
        ratingBar.setRating(rating);
        //  descTxt.setText(descDetailTxt);
        descTxt.setText(desc);
        img.setImageResource(image);
        txtyoutube.setText(youtube);

        //Itemclick
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendetailactivity(name, desc, url, image, youtube);
            }
        });
        return convertView;


    }


    // open detail activity and passdata
    private void opendetailactivity(String name, String desc, String url, int image, String youtube) {
        Intent i = new Intent(c, item_details.class);
        //packdata
        i.putExtra("name_key", name);
        i.putExtra("desc_key", desc);
        i.putExtra("url_key", url);
        // i.putExtra("desc_key",desc);
        i.putExtra("image_key", image);
        i.putExtra("youtube_key", youtube);
        //open activity

        c.startActivity(i);


    }


    @Override
    public Filter getFilter() {

        if (filter == null) {
            filter = new CustomFilter(filterList, this);
        }

        return filter;
    }


}


