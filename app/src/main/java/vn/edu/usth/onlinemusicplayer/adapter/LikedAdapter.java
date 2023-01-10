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
    ArrayList<likedSong> arrayLikedSong;
    View view;

    public LikedAdapter(Context context, ArrayList<LikedSong> arrayLikedSong) {
        this.context = context;
        this.arrayLikedSong = arraylikedSong;
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
        Model LikedSong = arrayLikedSong.get(position);
        holder.txtSong.setText(LikedSong.getSongName());
        holder.txtSinger.setText(LikedSong.getSingerName());
        Picasso.get().load(LikedSong.getSongImage()).into(holder.img);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("LikedSong", arrayLikedSong.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangbaihatyeuthich.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtTenBaiHat, txtTenCaSi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgLikedSong);
            txtSongName = itemView.findViewById(R.id.txtLikedSongName);
            txtSingerName = itemView.findViewById(R.id.txLikedSinger);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("LikedSong", arrayLikedSong.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}


