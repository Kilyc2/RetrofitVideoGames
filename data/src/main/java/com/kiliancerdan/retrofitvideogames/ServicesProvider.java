package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ServicesProvider {

    @GET("games/")
    Call<List<GameResponse>> getGames(@Query("search") String search);


    @GET("games/{id}/")
    @Headers({"Accept: application/json",
            "X-Mashape-Key: ***"})
    Call<List<GameResponse>> getGame(@Path("id") String idGame);

}
