package com.kiliancerdan.retrofitvideogames.Module;

import com.kiliancerdan.retrofitvideogames.Module.Game.Game;

import java.util.List;

public class GameListResponse {

    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

}
