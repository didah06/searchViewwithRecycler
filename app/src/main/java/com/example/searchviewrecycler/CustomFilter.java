package com.example.searchviewrecycler;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

class CustomFilter extends Filter {
    RecyclerViewAdapter adapter;
    List<DataFilter> filterList;
    public CustomFilter(List<DataFilter> filterList, RecyclerViewAdapter adapter) {
        this.adapter=adapter;
        this.filterList= filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<DataFilter> filteredPlayers=new ArrayList<>();
            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getNama().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }
            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.players= (ArrayList<DataFilter>) results.values;
        //REFRESH
        adapter.notifyDataSetChanged();

    }
}
