package np.cnblabs.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import np.cnblabs.recyclerview.adapter.CustomAdapter;
import np.cnblabs.recyclerview.model.Movie;

public class MainActivity extends AppCompatActivity {

    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    private List<Movie> movieList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        customAdapter = new CustomAdapter(this, movieList);
        recyclerView.setAdapter(customAdapter);

        feedData();

        customAdapter.setOnClick(new CustomAdapter.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void feedData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Mad Max1: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Mad Max2: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Mad Max3: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Mad Max4: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Mad Max5: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Mad Max6: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

    }
}
