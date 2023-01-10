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
import vn.edu.usth.onlinemusicplayer.model.Topic;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder>{

    Context context;
    ArrayList <Topic> TopicInternet;
    View view;

    public TopicAdapter(Context context, ArrayList <Topic> ArrayTopic ) {
        this.context = context;
        this.TopicInternet = TopicInternet;
    }

    @NonNull
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.genre_Topic,parent, false);
        return new TopicAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicAdapter.ViewHolder holder, final int position) {
        Topic topic = Array.get(position);
        holder.TopicName.setText(topic.getTopicName());
        Picasso.get(/*context*/).load(topic.getTopicImage()).into(holder.imgTopic);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SongPlaylistActivity.class);
                intent.putExtra("printTopicName", TopicInternet.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return TopicInternet != null ? TopicInternet.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTopic;
        TextView TopicName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTopic = itemView.findViewById(R.id.imageviewTopic);
            TopicName = itemView.findViewById(R.id.textTopicName);
        }
    }
}

