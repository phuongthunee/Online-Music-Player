package vn.edu.usth.onlinemusicplayer.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import vn.edu.usth.onlinemusicplayer.R;

public class SearchFragment extends Fragment {
    View view;
    androidx.appcompat.widget.Toolbar toolbarSearch;
    RecyclerView searchRecycler;
    TextView Search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search,container, false);
        toolbarSearch = view.findViewById(R.id.toolbarSearch);
        searchRecycler = view.findViewById(R.id.searchRecycler);
        View search = view.findViewById(R.id.search);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarSearch);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchRecycler.setBackgroundColor(Color.BLACK);
                if (!s.trim().equals("")) {
                    Search(s);
                }
                return true;
            }

            private void Search(String s) {
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }


    public class SearchFragment extends AppCompatActivity {
        private TextView Search;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_search);

            Search = findViewById(R.id.search);

            Search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(SearchFragment.this, Search.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
            });

        }
    }}



