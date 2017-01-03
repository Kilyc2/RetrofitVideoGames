package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.module.GameMapper;
import com.kiliancerdan.retrofitvideogames.module.game.Game;
import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class VideoGamesPresenter implements Callback<List<GameResponse>> {

    private VideoGamesView view;
    private GamesInteractor gamesInteractor;

    VideoGamesPresenter(VideoGamesView view) {
        this.view = view;
        gamesInteractor = new GamesInteractor();
    }

    void getGames(String search) {
        gamesInteractor.getGames(this, search);
    }

    void getGame(String idGame) {
        gamesInteractor.getGame(this, idGame);
    }

    @Override
    public void onResponse(Call<List<GameResponse>> call, Response<List<GameResponse>> response) {
        GameMapper mapper = new GameMapper();
        List<Game> games = mapper.convertResponseToGames(response.body());
        view.showGames(games);
    }

    @Override
    public void onFailure(Call<List<GameResponse>> call, Throwable t) {
        view.showError(t.getMessage());
    }

    interface VideoGamesView {
        void showGames(List<Game> games);
        void showError(String message);
    }
}
