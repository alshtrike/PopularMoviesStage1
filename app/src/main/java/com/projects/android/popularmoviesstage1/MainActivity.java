package com.projects.android.popularmoviesstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.projects.android.popularmoviesstage1.Utils.ApiKeyReader;
import com.projects.android.popularmoviesstage1.Utils.MovieRequestBuilder;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String mMovieRequest = "";
    private MovieRequestBuilder mRequestBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = "";

        try {
            apiKey = ApiKeyReader.readApiKey(this, getString(R.string.path_to_apikey));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!apiKey.isEmpty()){
            mRequestBuilder = new MovieRequestBuilder(apiKey, this);
        }

        if(mRequestBuilder!=null){
            mMovieRequest = mRequestBuilder.buildPopularMoviesRequest();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.sort_by_popular:
                sortMoviesByPopular();
                return true;
            case R.id.sort_by_top_rated:
                sortMoviesByTopRated();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void sortMoviesByTopRated() {
        //TODO make this do real stuff, showing toast for now
        showToast("Top Rated Movies");
    }

    private void sortMoviesByPopular() {
        //TODO make this do real stuff, showing toast for now
        showToast("Popular Movies");
    }

    private void showToast(String toastText){
        Toast toast = Toast.makeText(this, toastText, Toast.LENGTH_LONG);
        toast.show();
    }
}