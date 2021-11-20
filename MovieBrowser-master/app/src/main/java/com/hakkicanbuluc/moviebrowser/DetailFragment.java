package com.hakkicanbuluc.moviebrowser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    private Movie movie;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(Movie movie) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = getArguments().getParcelable("movie");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txtName = view.findViewById(R.id.txtMovieName);
        txtName.setText(movie.getName());

        TextView txtYear = view.findViewById(R.id.txtYear);
        txtYear.setText(String.valueOf(movie.getYear()));

        TextView txtDirector = view.findViewById(R.id.txtDirector);
        txtDirector.setText(movie.getDirector());

        TextView txtDescription = view.findViewById(R.id.txtDescription);
        txtDescription.setText(movie.getDescription());

        txtDescription.setEnabled(false);

        ListView listView = view.findViewById(R.id.lstStars);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.array_adapter,
                movie.getStars().toArray(new String[1])));
    }

    public void setMovie(View view, Movie movie) {
        this.movie = movie;

        TextView txtName = view.findViewById(R.id.txtMovieName);
        txtName.setText(movie.getName());

        TextView txtYear = view.findViewById(R.id.txtYear);
        txtYear.setText(String.valueOf(movie.getYear()));

        TextView txtDirector = view.findViewById(R.id.txtDirector);
        txtDirector.setText(movie.getDirector());

        TextView txtDescription = view.findViewById(R.id.txtDescription);
        txtDescription.setText(movie.getDescription());

        txtDescription.setEnabled(false);

        ListView listView = view.findViewById(R.id.lstStars);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.array_adapter,
                movie.getStars().toArray(new String[1])));
    }
}