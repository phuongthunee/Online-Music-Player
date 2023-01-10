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
import vn.edu.usth.onlinemusicplayer.model.Playlist;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

        Context context;
        ArrayList<Playlist> PlaylistInternet;
        View view;

        public PlaylistAdapter(Context context, ArrayList<Playlist> PlaylistInternet) {
            this.context = context;
            this.PlaylistInternet = PlaylistInternet;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.genre_Playlist,parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            Playlist Playlist = PlaylistInternet.get(position);
            holder.PlaylistName.setText(Playlist.getPlaylistName());
            Picasso.get().load(Playlist.getPlaylistImage()).into(holder.imgPlaylist);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaylistSongActivity.class);
                    intent.putExtra("intentPlaylist", PlaylistInternet.get(position));
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return PlaylistInternet != null ? PlaylistInternet.size() : 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imgPlaylist;
            TextView PlaylistName;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imgPlaylistlaylist = itemView.findViewById(R.id.imageviewPlaylist);
                PlaylistName = itemView.findViewById(R.id.textviewPlaylist);
            }
        }

    }}