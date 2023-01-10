package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Playlist implements Serializable {
    @SerializedName ("PlaylistId")
    @Expose
    private String PlaylistId;
    @SerializeName ("PlaylistName")
    @Expose
    private String PlaylistName;
    @SerializeName ("PlaylistImage")
    @Expose
    private String PlaylistImage;


    public String getPlaylistId() {
        return PlaylistId;
    }
    public void setPlaylistId(String PlaylistId) {
        this.PlaylistId = PlaylistId;
    }
    public String getPlaylistName(){
        return PlaylistName;
    }
    public void setPlaylistName(String PlaylistName){
        this.PlaylistName = PlaylistName;
    }
    public String getPlaylistImage(){
        return PlaylistImage;
    }
    public void setPlaylistImage(String PlaylistImage){
        this.PlaylistImage = PlaylistImage;
    }
}
