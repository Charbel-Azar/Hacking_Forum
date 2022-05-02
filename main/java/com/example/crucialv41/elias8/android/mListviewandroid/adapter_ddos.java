package com.example.crucialv41.elias8.android.mListviewandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crucialv41.elias8.R;

import com.example.crucialv41.elias8.android.mDataandroid.apps_ddos;
import com.example.crucialv41.elias8.mDetail.item_details;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;

public class adapter_ddos extends BaseAdapter {
    Context c;
    ArrayList<apps_ddos> appss;

    LayoutInflater inflater;
    public adapter_ddos(Context c, ArrayList<apps_ddos> appss) {
        this.c = c;
        this.appss = appss;
        inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if(convertView==null){
            convertView=inflater.inflate(R.layout.model,parent,false);

        }
        TextView nameTxt=(TextView)convertView.findViewById(R.id.nameTxt);
        TextView urlTxt=(TextView)convertView.findViewById(R.id.url);
        TextView descTxt=(TextView)convertView.findViewById(R.id.descTxt);
        ImageView img=(ImageView)convertView.findViewById(R.id.airdroid);
        SimpleRatingBar ratingBar= (SimpleRatingBar)convertView.findViewById(R.id.ratingBarID);

        final String name=appss.get(position).getName();
        final String desc=appss.get(position).getDesc();
        final String url=appss.get(position).getUrl();
        final int image=appss.get(position).getImage();

        final int rating=appss.get(position).getRating();
        ratingBar.setFocusable(false);
        ratingBar.setClickable(false);
        //bind data
        nameTxt.setText(name);
        urlTxt.setText(url);
        ratingBar.setRating(rating);
        //  descTxt.setText(descDetailTxt);
        descTxt.setText(desc);
        img.setImageResource(image);

        //Itemclick
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendetailactivity(name,desc,url,image,rating);
            }
        });
        return convertView;
    }


    // open detail activity and passdata
    private void opendetailactivity(String name,String desc,String url, int image,int rating)
    {
        Intent i =new Intent(c, item_details.class);
        //packdata
        i.putExtra("name_key",name);
        i.putExtra("rating_key",rating);
        i.putExtra("desc_key",desc);
        i.putExtra("url_key",url);
        // i.putExtra("desc_key",desc);
        i.putExtra("image_key",image);
        //open activity
        c.startActivity(i);
    }

}

