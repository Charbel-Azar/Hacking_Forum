package com.example.crucialv41.elias8;

import android.widget.Filter;

import com.example.crucialv41.elias8.android.mDataandroid.apps_anonymous;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    ArrayList<apps_anonymous> filterList;
   com.example.crucialv41.elias8.android.mListviewandroid.adapter_anonymous adapter;

    public CustomFilter(ArrayList<apps_anonymous> filterList, com.example.crucialv41.elias8.android.mListviewandroid.adapter_anonymous adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    //FILTERING
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        //RESULTS
        FilterResults results=new FilterResults();

        //VALIDATION
        if(constraint != null && constraint.length()>0)
        {

            //CHANGE TO UPPER FOR CONSISTENCY
            constraint=constraint.toString().toUpperCase();

            ArrayList<apps_anonymous> filteredMovies=new ArrayList<>();

            //LOOP THRU FILTER LIST
            for(int i=0;i<filterList.size();i++)
            {
                //FILTER
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    filteredMovies.add(filterList.get(i));
                }
            }

            results.count=filteredMovies.size();
            results.values=filteredMovies;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    //PUBLISH RESULTS

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.appss= (ArrayList<apps_anonymous>) results.values;
        adapter.notifyDataSetChanged();

    }
}