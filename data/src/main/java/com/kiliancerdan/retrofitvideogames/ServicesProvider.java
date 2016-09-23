package com.kiliancerdan.retrofitvideogames;

import com.kiliancerdan.retrofitvideogames.Module.GameListResponse;
import com.kiliancerdan.retrofitvideogames.Module.GameResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

interface ServicesProvider {

    @Headers("Accept: application/json")
    @GET("games")
    Call<GameListResponse> getGames();


    @Headers("Accept: application/json")
    @GET("games/{id}/")
    Call<GameResponse> getGame(@Path("id") int idGame);

}
