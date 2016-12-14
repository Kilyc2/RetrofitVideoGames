package com.kiliancerdan.retrofitvideogames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kiliancerdan.retrofitvideogames.module.game.Game;
import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.util.ArrayList;
import java.util.List;

public class VideoGamesActivity extends AppCompatActivity implements VideoGamesPresenter.VideoGamesView {

    RecyclerView videoGameList;
    VideoGamesAdapter adapter;
    VideoGamesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogames);
        presenter = new VideoGamesPresenter(this);
        adapter = new VideoGamesAdapter(new ArrayList<Game>());
        videoGameList = (RecyclerView)findViewById(R.id.list_games);
        videoGameList.setItemAnimator(new DefaultItemAnimator());
        videoGameList.setLayoutManager(new LinearLayoutManager(this));
        videoGameList.setHasFixedSize(true);
        videoGameList.setAdapter(adapter);
        Button getGameButton = (Button)findViewById(R.id.button_game);
        getGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getGame("7334");
            }
        });
        Button getGameListButton = (Button)findViewById(R.id.button_game_list);
        getGameListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getGames();
            }
        });
    }

    @Override
    public void showGames(List<Game> games) {
        adapter.setGames(games);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
