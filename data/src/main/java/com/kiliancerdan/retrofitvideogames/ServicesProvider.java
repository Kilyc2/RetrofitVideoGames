package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

interface ServicesProvider {

    @Headers("Accept: application/json")
    @GET("games/")
    Call<List<GameResponse>> getGames();


    @Headers({"Accept: application/json",
            "X-Mashape-Key: MiHI6MYPqVmshNOW4nk86GEcEWotp1e6vPfjsnQivQOFjTCWJf"})
    @GET("games/{id}/")
    Call<List<GameResponse>> getGame(@Path("id") String idGame);

}
