package com.example.searchviewrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private static final String TAG = "MainActivity";


        private RecyclerView rv;
        private RecyclerViewAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //sv= (SearchView) findViewById(R.id.mSearch);
            rv= (RecyclerView) findViewById(R.id.myRecycler);
            //SET ITS PROPERTIES
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setItemAnimator(new DefaultItemAnimator());
            //ADAPTER
            adapter=new RecyclerViewAdapter(this,getPlayers());
            rv.setAdapter(adapter);

        }


        //ADD PLAYERS TO ARRAYLIST
        private ArrayList<DataFilter> getPlayers() {
            ArrayList<DataFilter> players=new ArrayList<>();
            DataFilter p=new DataFilter();
            p.setNama("Home");
            p.setImageID(R.drawable.gili);
            players.add(p);

            p=new DataFilter();
            p.setNama("Contacts");
            p.setImageID(R.drawable.kepulauananambas);
            players.add(p);

            p=new DataFilter();
            p.setNama("Images");
            p.setImageID(R.drawable.lautbunaken);
            players.add(p);

            p=new DataFilter();
            p.setNama("Videos");
            p.setImageID(R.drawable.mandalika);
            players.add(p);

            p=new DataFilter();
            p.setNama("Mails");
            p.setImageID(R.drawable.nusadua);
            players.add(p);

            return players;

        }

        @Override
        public boolean onCreateOptionsMenu( Menu menu) {
            getMenuInflater().inflate( R.menu.item_menu, menu);
            final MenuItem item = menu.findItem(R.id.action_search);
            final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String query) {
                    //FILTER AS YOU TYPE
                    adapter.getFilter().filter(query);
                    return false;
                }
            });
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            //noinspection SimplifiableIfStatement

            return true;
        }

    }
