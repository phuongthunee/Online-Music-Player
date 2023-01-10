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
        ArrayList<PlaylistModel> ArrayPlaylist;
        View view;

        public PlaylistAdapter(Context context, ArrayList<PlaylistModel> ArrayPlaylist) {
            this.context = context;
            this.ArrayPlaylist = ArrayPlaylist;
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
            PlaylistModel Playlist = ArrayPlaylist.get(position);
            holder.txtPlaylistName.setText(Playlist.getPlaylistName());
            Picasso.get().load(Playlist.getPlaylistImage()).into(holder.imgPlaylist);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaylistSongActivity.class);
                    intent.putExtra("intentPlaylist", ArrayPlaylist.get(position));
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return ArrayPlaylist != null ? ArrayPlaylist.size() : 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imgPlaylist;
            TextView txtPlaylistName;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imgPlaylistlaylist = itemView.findViewById(R.id.imageviewPlaylist);
                txtPlaylistName = itemView.findViewById(R.id.textviewPlaylist);
            }
        }

    }}