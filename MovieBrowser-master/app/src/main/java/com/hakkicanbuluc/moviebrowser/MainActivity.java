package com.hakkicanbuluc.moviebrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MovieListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void movieSelected(Movie movie) {
        int display_mode = getResources().getConfiguration().orientation;
        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("movie", movie);
            startActivity(intent);
        } else {
            DetailFragment df = (DetailFragment) getSupportFragmentManager().findFragmentByTag(
                    "details");
            if (df == null) {
                FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                df = DetailFragment.newInstance(movie);
                fts.add(R.id.container, df, "details");
                fts.commit();
            } else {
                df.setMovie(findViewById(R.id.container), movie);
            }
        }
    }
}