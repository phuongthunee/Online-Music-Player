package vn.edu.usth.onlinemusicplayer.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import vn.edu.usth.onlinemusicplayer.SongPlaylist;
import vn.edu.usth.onlinemusicplayer.model.SongPlaylist;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongPlaylistAdapter extends RecyclerView.Adapter<SongPlaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<SongPlaylist> SongPlaylistInternet;

    public SongPlaylistAdapter(Context context, ArrayList<SongPlaylist> ArraySong) {
        this.context = context;
        this.SongPlaylistInternet = SongPlaylistInternet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.genre_SongPlaylist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SongPlaylist song = SongPlaylistInternet.get(position);
        holder.SongName.setText(Song.getSongName());
        holder.SingerName.setText(Song.getSingerName());
        Picasso.get().load(Song.getSongImage()).into(holder.SongImage);
    }

    @Override
    public int getItemCount() {
        return SongPlaylistInternet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView SongName, SingerName;
        ImageView SongImage, Search;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SongName = itemView.findViewById(R.id.textViewSongName);
            SingerName = itemView.findViewById(R.id.textViewSingerName);
            SongImage = itemView.findViewById(R.id.imageViewSongImage);
            Search = itemView.findViewById(R.id.imageViewSearchSongPlaylist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("Song", SongPlaylistInternet.get(getAdapterPosition()));
                    context.startActivity(intent);

                }
            });
        }
    }
}

