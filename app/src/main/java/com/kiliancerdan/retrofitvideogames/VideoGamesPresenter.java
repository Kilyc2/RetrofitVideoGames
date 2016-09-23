package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.Module.Game.Game;
import com.kiliancerdan.retrofitvideogames.Module.GameListResponse;
import com.kiliancerdan.retrofitvideogames.Module.GameResponse;

import java.util.ArrayList;
import java.util.List;

class VideoGamesPresenter implements GameListInteractor.Callback, GameInteractor.Callback {

    private VideoGamesView view;
    private GameListInteractor gameListInteractor;
    private GameInteractor gameInteractor;

    VideoGamesPresenter(VideoGamesView view) {
        this.view = view;
        gameListInteractor = new GameListInteractor();
        gameInteractor = new GameInteractor();
    }

    void getGames() {
        gameListInteractor.getGames(this);
    }

    void getGame(int idGame) {
        gameInteractor.getGame(this, idGame);
    }

    @Override
    public void onGamesSuccess(GameListResponse gameListResponse) {
        List<Game> games = gameListResponse.getGames();
        view.showGames(games);
    }

    @Override
    public void onGamesSuccess(GameResponse gameResponse) {
        List<Game> games = new ArrayList<>();
        games.add(gameResponse.getGame());
        view.showGames(games);
    }

    interface VideoGamesView {
        void showGames(List<Game> games);
    }
}
