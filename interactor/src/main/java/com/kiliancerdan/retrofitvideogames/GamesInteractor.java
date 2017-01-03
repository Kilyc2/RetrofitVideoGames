package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;

class GamesInteractor {

    private Retrofit retrofit = RetrofitInstance.getRetrofit();

    void getGames(Callback<List<GameResponse>> callback, String search) {
        ServicesProvider servicesProvider = retrofit.create(ServicesProvider.class);
        servicesProvider.getGames(search).enqueue(callback);
    }

    void getGame(Callback<List<GameResponse>> callback, String idGame) {
        ServicesProvider servicesProvider = retrofit.create(ServicesProvider.class);
        servicesProvider.getGame(idGame).enqueue(callback);
    }
}
