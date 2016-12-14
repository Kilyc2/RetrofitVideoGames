package com.kiliancerdan.retrofitvideogames;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiliancerdan.retrofitvideogames.module.game.Cover;
import com.kiliancerdan.retrofitvideogames.module.game.Game;
import com.squareup.picasso.Picasso;

import java.util.List;

class VideoGamesAdapter extends RecyclerView.Adapter<VideoGamesAdapter.ViewHolder> {

    private List<Game> games;

    VideoGamesAdapter(List<Game> games) {
        this.games = games;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_videogame, parent, false);
        return new ViewHolder(view);
    }

    void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game game = games.get(position);
        holder.itemView.setTag(game);
        holder.gameName.setText(game.getName());
        holder.gameReleaseDate.setText(game.getReleaseDate());
        Cover cover = game.getCover();
        if (cover != null) {
            holder.gameImage.setVisibility(View.VISIBLE);
            setImage(holder, "https://images.igdb.com/igdb/image/upload/t_cover_big/"
                    .concat(cover.getId()).concat(".png"));
        } else {
            holder.gameImage.setVisibility(View.INVISIBLE);
        }
    }

    private void setImage(ViewHolder holder, String urlCover) {
        Context context = holder.itemView.getContext();
        Uri uri = Uri.parse(urlCover);
        Picasso.with(context).load(uri).fit().centerInside().into(holder.gameImage);
    }

    @Override
    public int getItemCount() {
        return games.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView gameName;
        TextView gameReleaseDate;
        ImageView gameImage;

        ViewHolder(View itemView) {
            super(itemView);
            gameName = (TextView)itemView.findViewById(R.id.item_game_name);
            gameReleaseDate = (TextView)itemView.findViewById(R.id.item_game_release_date);
            gameImage = (ImageView)itemView.findViewById(R.id.item_game_cover);
        }
    }
}
