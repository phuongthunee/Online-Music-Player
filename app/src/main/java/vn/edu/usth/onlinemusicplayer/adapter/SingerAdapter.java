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
import vn.edu.usth.onlinemusicplayer.model.Singer;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHolder> {
    Context context;
    ArrayList<Singer> arraySinger;
    View view;

    public SingerAdapter(Context context, ArrayList<Singer> arraySinger) {
        this.context = context;
        this.arraySinger = arraySinger;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.genre_Singer,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Singer Singer = arraySinger.get(position);
        holder.txtSingerName.setText(Singer.getSingerName());
        Picasso.get(/*context*/).load(Singer.getSingerImage()).into(holder.imgSinger);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SongPlaylistActivity.class);
                intent.putExtra("printSingerName", arraySinger.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraySinger != null ? arraySinger.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        de.hdodenhof.circleimageview.CircleImageView imgSinger;
        TextView txtSingerName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSinger = itemView.findViewById(R.id.imageviewnSinger);
            txtSingerName = itemView.findViewById(R.id.textviewSinger);
        }
    }
}
