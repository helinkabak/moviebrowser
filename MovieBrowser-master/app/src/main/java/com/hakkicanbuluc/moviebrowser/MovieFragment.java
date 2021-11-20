package com.hakkicanbuluc.moviebrowser;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class MovieFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private MovieListener mListener;

    List<Movie> movies = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieFragment() {
    }

    @SuppressWarnings("unused")
    public static MovieFragment newInstance(int columnCount) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        movies.add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994,
                Arrays.asList("Tim Robbins", "Morgan Freeman", "Bob Gunton"), "" +
                "Two imprisoned men bond over a number of years, finding solace and eventual " +
                "redemption through acts of common decency."));

        movies.add(new Movie("The GodFather", "Francis Ford Coppola", 1972,
                Arrays.asList("Marlon Brando", "Al PAcino", "James Caan"), "The aging" +
                " patriarch of an organized crime dynasty in postwar New York City transfers " +
                "control of his clandestine empire to his reluctant youngest son."));

        movies.add(new Movie("Pulp Fiction", "Quentin Tarantino", 1994,
                Arrays.asList("John Travolta", "Uma Thurman", "Samuel L. Jackson"),
                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a" +
                        " pair of diner bandits intertwine in four tales of violence and " +
                        "redemption."));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyMovieRecyclerViewAdapter(movies, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MovieListener) {
            mListener = (MovieListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MovieListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}