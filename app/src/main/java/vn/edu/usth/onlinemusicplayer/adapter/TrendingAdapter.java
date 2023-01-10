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
import vn.edu.usth.onlinemusicplayer.model.Trending;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    Context context;
    ArrayList<Trending> trendingInternet;
    View view;

    public TrendingAdapter(Context context, ArrayList<Trending> trendingInternet) {
        this.context = context;
        this.trendingInternet = trendingInternet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.genre_Trending,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Trending Trending = trendingInternet.get(position);
        holder.TrendingName.setText(Trending.getTrendingName());
        Picasso.get(/*context*/).load(Trending.getTrendingImage()).into(holder.imgpthinhhanh);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SongPlaylist.class);
                intent.putExtra("printTrendingName", trendingInternet.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trendingInternet != null ? trendingInternet.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTrending;
        TextView txtTrendingName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTrending = itemView.findViewById(R.id.imageviewTrending);
            txtTrendingName = itemView.findViewById(R.id.textviewTrending);
        }
    }
}
