package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.module.game.Game;

import java.util.List;

class VideoGamesPresenter implements GamesInteractor.Callback {

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
    public void onGamesSuccess(List<Game> games) {
        view.showGames(games);
    }

    @Override
    public void onGamesFailed(String message) {
        view.showError(message);
    }

    interface VideoGamesView {
        void showGames(List<Game> games);
        void showError(String message);
    }
}
