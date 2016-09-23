package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.Module.GameListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

class GameListInteractor implements Callback<GameListResponse> {

    private Retrofit retrofit = RetrofitInstance.getRetrofit();
    private Callback callback;

    void getGames(Callback callback) {
        this.callback = callback;
        ServicesProvider servicesProvider = retrofit.create(ServicesProvider.class);
        servicesProvider.getGames().enqueue(this);
    }

    @Override
    public void onResponse(Call<GameListResponse> call, Response<GameListResponse> response) {
        callback.onGamesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<GameListResponse> call, Throwable t) {

    }

    interface Callback {
        void onGamesSuccess(GameListResponse gameListResponse);
    }
}
