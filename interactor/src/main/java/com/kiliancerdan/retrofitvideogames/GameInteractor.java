package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.Module.GameResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

class GameInteractor implements Callback<GameResponse> {

    private Retrofit retrofit = RetrofitInstance.getRetrofit();
    private Callback callback;

    void getGame(final Callback callback, int idGame) {
        this.callback = callback;
        ServicesProvider servicesProvider = retrofit.create(ServicesProvider.class);
        servicesProvider.getGame(idGame).enqueue(this);
    }

    @Override
    public void onResponse(Call<GameResponse> call, Response<GameResponse> response) {
        callback.onGamesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<GameResponse> call, Throwable t) {

    }

    interface Callback {
        void onGamesSuccess(GameResponse gameResponse);
    }
}
