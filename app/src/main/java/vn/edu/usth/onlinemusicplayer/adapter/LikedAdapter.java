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
import vn.edu.usth.onlinemusicplayer.model.Liked;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LikedAdapter extends RecyclerView.Adapter<LikedAdapter.ViewHolder>{

    Context context;
    ArrayList<likedSong> LikedSongInternet;
    View view;

    public LikedAdapter(Context context, ArrayList<LikedSong> LikedSongInternet) {
        this.context = context;
        this.LikedSongInternet = LikedSongInternet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.genre_Liked,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model LikedSong = LikedSongInternet.get(position);
        holder.Song.setText(LikedSong.getSongName());
        holder.Singer.setText(LikedSong.getSingerName());
        Picasso.get().load(LikedSong.getSongImage()).into(holder.img);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("LikedSong", LikedSongInternet.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return LikedSongInternet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView TenBaiHat, TenCaSi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgLikedSong);
            SongName = itemView.findViewById(R.id.LikedSongName);
            SingerName = itemView.findViewById(R.id.LikedSinger);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("LikedSong", LikedSongInternet.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}


