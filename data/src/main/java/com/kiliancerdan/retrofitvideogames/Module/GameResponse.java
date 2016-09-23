package com.kiliancerdan.retrofitvideogames.Module;


import com.google.gson.annotations.SerializedName;
import com.kiliancerdan.retrofitvideogames.Module.Game.Game;

public class GameResponse {

    @SerializedName("game")
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
