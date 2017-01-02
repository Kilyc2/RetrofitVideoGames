package com.kiliancerdan.retrofitvideogames.module;

import com.kiliancerdan.retrofitvideogames.module.game.Cover;
import com.kiliancerdan.retrofitvideogames.module.game.Game;
import com.kiliancerdan.retrofitvideogames.module.game.Video;
import com.kiliancerdan.retrofitvideogames.response.game.CoverResponse;
import com.kiliancerdan.retrofitvideogames.response.game.GameResponse;
import com.kiliancerdan.retrofitvideogames.response.game.VideoResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GameMapper {

    public List<Game> convertResponseToGames(List<GameResponse> gameResponseList) {
        List<Game> games = new ArrayList<>();
        if (gameResponseList != null) {
            for (GameResponse gameResponse : gameResponseList) {
                Game game = new Game();
                game.setId(gameResponse.getId());
                game.setName(gameResponse.getName());
                game.setRating(gameResponse.getRating());
                game.setSummary(gameResponse.getSummary());
                game.setReleaseDate(getFormattedDate(gameResponse.getReleaseDate()));
                List<Video> videos = convertResponseToVideos(gameResponse.getVideos());
                game.setVideos(videos);
                game.setCover(convertResponseToCover(gameResponse.getCover()));
                games.add(game);
            }
        }
        return games;
    }

    private List<Video> convertResponseToVideos(List<VideoResponse> videoResponseList) {
        List<Video> videos = new ArrayList<>();
        if (videoResponseList != null) {
            for (VideoResponse videoResponse : videoResponseList) {
                videos.add(convertResponseToVideo(videoResponse));
            }
        }
        return videos;
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
        }
        return cover;
    }

    private Video convertResponseToVideo(VideoResponse response) {
        Video video = new Video();
        if (response != null) {
            video.setName(response.getName());
            video.setId(response.getId());
        }
        return video;
    }

}
