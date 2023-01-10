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
    ArrayList<Song> ArraySong;

    public SongPlaylistAdapter(Context context, ArrayList<Song> ArraySong) {
        this.context = context;
        this.ArraySong = ArraySong;
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
        Song song = ArraySong.get(position);
        holder.txtSongName.setText(Song.getSongName());
        holder.txtSingerName.setText(Song.getSingerName());
        Picasso.get().load(Song.getSongImage()).into(holder.SongImage);
    }

    @Override
    public int getItemCount() {
        return ArraySong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtSongName, txtSingerName;
        ImageView SongImage, Search;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSongName = itemView.findViewById(R.id.textViewSongName);
            txtSingerName = itemView.findViewById(R.id.textViewSingerName);
            SongImage = itemView.findViewById(R.id.imageViewSongImage);
            Search = itemView.findViewById(R.id.imageViewSearchSongPlaylist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayerActivity.class);
                    intent.putExtra("Song", ArraySong.get(getAdapterPosition()));
                    context.startActivity(intent);

                }
            });
        }
    }
}

