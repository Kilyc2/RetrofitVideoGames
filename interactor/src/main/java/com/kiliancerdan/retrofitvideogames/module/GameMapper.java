package com.kiliancerdan.retrofitvideogames.module;

import com.kiliancerdan.retrofitvideogames.module.game.Cover;
import com.kiliancerdan.retrofitvideogames.module.game.Game;
import com.kiliancerdan.retrofitvideogames.response.game.CoverResponse;
import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GameMapper {

    public List<Game> convertResponseToGames(List<GameResponse> response) {
        List<Game> games = new ArrayList<>();
        for (GameResponse gameResponse : response) {
            Game game = new Game();
            game.setName(gameResponse.getName());
            game.setCategory(gameResponse.getCategory());
            game.setRating(gameResponse.getRating());
            game.setSummary(gameResponse.getSummary());
            game.setReleaseDate(getFormattedDate(gameResponse.getReleaseDate()));
            game.setCover(convertResponseToCover(gameResponse.getCover()));
            games.add(game);
        }
        return games;
    }

    private String getFormattedDate(Long dateInMilliseconds) {
        String dateFormatted = "";
        if (dateInMilliseconds != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dateInMilliseconds);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            dateFormatted = dateFormat.format(date);
        }
        return dateFormatted;
    }

    private Cover convertResponseToCover(CoverResponse response) {
        Cover cover = new Cover();
        if (response != null) {
            cover.setId(response.getId());
            cover.setHeight(response.getHeight());
            cover.setWidth(response.getWidth());
        }
        return cover;
    }

}
