package com.hakkicanbuluc.moviebrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Movie movie = getIntent().getParcelableExtra("movie");

        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        DetailFragment df = DetailFragment.newInstance(movie);
        fts.add(R.id.container, df);
        fts.commit();
    }
}