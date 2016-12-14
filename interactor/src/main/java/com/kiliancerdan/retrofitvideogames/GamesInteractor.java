package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.module.GameMapper;
import com.kiliancerdan.retrofitvideogames.module.game.Game;
import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

class GamesInteractor implements Callback<List<GameResponse>> {

    private Retrofit retrofit = RetrofitInstance.getRetrofit();
    private Callback callback;

    void getGames(Callback callback) {
        this.callback = callback;
        ServicesProvider servicesProvider = retrofit.create(ServicesProvider.class);
        servicesProvider.getGames().enqueue(this);
    }

    void getGame(Callback callback, String idGame) {
        this.callback = callback;
        ServicesProvider servicesProvider = retrofit.create(ServicesProvider.class);
        servicesProvider.getGame(idGame).enqueue(this);
    }

    @Override
    public void onResponse(Call<List<GameResponse>> call, Response<List<GameResponse>> response) {
        GameMapper mapper = new GameMapper();
        callback.onGamesSuccess(mapper.convertResponseToGames(response.body()));
    }

    @Override
    public void onFailure(Call<List<GameResponse>> call, Throwable t) {
        callback.onGamesFailed(t.getMessage());
    }

    interface Callback {
        void onGamesSuccess(List<Game> gamesResponse);
        void onGamesFailed(String message);
    }
}
