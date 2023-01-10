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
import vn.edu.usth.onlinemusicplayer.model.CreateSongLibrary;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;
import vn.edu.usth.onlinemusicplayer.Service_API.APIService;
import vn.edu.usth.onlinemusicplayer.Service_API.Dataservice;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.onlinemusicplayer.model.SongLibraryPlaylist;

public class CreateSongLibraryAdapter extends RecyclerView.Adapter<CreateSongLibraryAdapter.ViewHolder>{

    Context context;
    ArrayList <SongLibraryPlaylist> SongInternet;
    int LibraryId;

    public CreateSongLibraryAdapter(Context context, ArrayList <SongLibraryList> SongInternet, int LibraryId) {
        this.context = context;
        this.SongInternet = SongInternet;
        this.LibraryId = LibraryId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.genre_Create_Song_Library, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song Song = SongInternet.get(position);
        holder.SongName.setText(Song.getSongName());
        holder.SingerName.setText(Song.getSingerName());
        Picasso.get(/*context*/).load(Song.getSongImage()).into(holder.imgSearch);
        holder.imgCreateSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDataSongLibrary(LibraryId, Song.getSongId(), Song.getSongName(),Song.getSingerName(),
                        Song.getSongImage(), Song.getSongLink());
                UpdateSongImage(LibraryId, SongInternet.get(position).getSongImgage());
            }
        });

    }
    public void CreateDataSongLibrary(int idtv, int idbh, String tbh, String tcs, String hbh, String lbh) {
        Dataservice dataservice = APIService.getService();
        Call<Response> callback = dataservice.CreateDataSongLibrary(idtv, idbh, tbh, tcs, hbh, lbh);
        callback.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                Response responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        Toast.makeText(context, "Add Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Add Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
            }

        });
    }

    public void UpdateLibraryImage(int idtv, String hbh) {
        Dataservice dataservice = APIService.getService();
        Call<Response> callback = dataservice.updateLibraryImage(idtv, hbh);
        callback.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                Response responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        Log.d("updateLibraryImage", "success");
                    } else {
                        Log.d("updateLibraryImage", "error");
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
            }

        });
    }

    @Override
    public int getItemCount() {
        return SongInterne.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView SongName, SingerName;
        ImageView imgSearch, imgCreateSong;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SongName = itemView.findViewById(R.id.SongPlaylistName);
            SingerName = itemView.findViewById(R.id.SongPlayListSinger);
            imgSearch = itemView.findViewById(R.id.imgSearch);
            imgCreateSong = itemView.findViewById(R.id.imgCreateSong);

        }
    }

