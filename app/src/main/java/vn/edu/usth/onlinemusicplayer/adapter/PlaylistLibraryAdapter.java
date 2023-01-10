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
import vn.edu.usth.onlinemusicplayer.model.PlaylistLibrary;
import vn.edu.usth.onlinemusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class PlaylistLibraryAdapter  extends RecyclerView.Adapter<PlaylistLibraryAdapter.ViewHolder> {

    Context context;
    ArrayList <PlaylistLibrary> PlaylistLibraryInternet;
    View view;
    private String Username;

    public PlaylistLibraryAdapter(Context context, ArrayList<PlaylistLibrary> PlaylistLibraryInternet, String Username) {
        this.context = context;
        this.PlaylistLibraryInternet = PlaylistLibraryInternet;
        this.Username = Username;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.genre_PlaylistLibrary,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlaylistLibrary playlistlibrary = PlaylistLibraryInternet.get(position);
        holder.PlaylistLibraryName.setText(PlaylistLibrary.getPlaylistLibraryName());
        holder.txtUsername.setText("Playlist's "+ Username);
        Picasso.get().load(PlayListLibrary.getPlaylistLibraryImage()).into(holder.imgPlaylistLibrary);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SongPlaylistActivity.class);
                intent.putExtra("PlaylistLibraryId", PlaylistLibraryInternet.get(position));
                context.startActivity(intent);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Delete Library")
                        .setMessage("Do you want delete Library"+PlayListLibrary.getPlaylistLibraryName()+" ?")
                        .setPositiveButton("Delete", null)
                        .setNegativeButton("Cancel", null)
                        .show();

                Button pos = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button neg = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                pos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DeleteLibrary(PlayListLibrary.getPlayListLibraryId());
                        DeleteSongsLibrary(PlayListLibrary.getPlayListLibraryId());
                        alertDialog.dismiss();
                    }
                });
                neg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                return false;
            }
        });

    }
    private void DeleteLibrary(int LibraryId) {

        Dataservice networkService = APIService.getService();
        Call<Response> login = networkService.DeleteLibrary(LibraryId);
        login.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull Response<Response> response) {
                Response responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        Toast.makeText(context, "Delete Successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Delete Failed", Toast.LENGTH_LONG).show();

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {

            }
        });
    }

    private void DeleteSongsLibrary(int LibraryId) {

        Dataservice networkService = APIService.getService();
        Call<Response> login = networkService.DeleteSongsLibrary(LibraryId);
        login.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull Response<Response> response) {
                Response responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {

                    } else {

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return PlaylistLibraryInternet != null ? PlaylistLibraryInternet.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlaylistLibrary;
        TextView PlaylistLibrary, Username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlaylistLibrary = view.findViewById(R.id.imageviewPlaylistLibrary);
            PlaylistLibrary = view.findViewById(R.id.textviewPlaylistLibrary);
            Username = view.findViewById(R.id.Usetname);
        }

    }
}


