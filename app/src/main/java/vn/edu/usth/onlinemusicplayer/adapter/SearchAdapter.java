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
import vn.edu.usth.onlinemusicplayer.model.SearchSong;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    Context context;
    ArrayList<Song> SongInternet;

    public SearchAdapter(Context context, ArrayList<Song> SongInternet) {
        this.context = context;
        this.SongInternet = SongInternet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.genre_Search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = SongInternet.get(position);
        holder.SearchName.setText(song.getSongName());
        holder.SearchSinger.setText(Song.getSingerName());
        Picasso.get().load(song.getSongImage()).into(holder.imgSearchImage);
    }

    @Override
    public int getItemCount() {
        return SongInternet.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtSearchName, txtSearchSinger;
        ImageView imgSearchImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SearchName = itemView.findViewById(R.id.SongName);
            SearchSinger = itemView.findViewById(R.id.Singer);
            imgSearchImage = itemView.findViewById(R.id.imgSong);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("Song", SongInternet.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }

}


