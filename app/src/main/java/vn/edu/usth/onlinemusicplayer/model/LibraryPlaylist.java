package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LibraryList implements Serializable {
    @SerializedName("LibraryPlaylistId")
    @Expose
    private int LibraryPlaylistId;

    @SerializedName("LibraryPlaylistName")
    @Expose
    private String LibraryPlaylistName;

    @SerializedName("LibraryPlaylistImage")
    @Expose
    private String LibraryPlaylistImage;

    @SerializedName("UserName")
    @Expose
    private String UserName;

    public int getLibraryPlaylistId() {
        return LibraryPlaylistId;
    }

    public void setLibraryPlaylistId(int LibraryPlaylistId) {
        this.LibraryPlaylistId = LibraryPlaylistId;
    }

    public String getLibraryPlaylistName() {
        return LibraryPlaylistName;
    }

    public void setLibraryPlaylistName(String LibraryPlaylistName) {
        this.LibraryPlaylistName = LibraryPlaylistName;
    }

    public String getLibraryPlaylistImage() {
        return LibraryPlaylistImage;
    }

    public void setLibraryPlaylistImage(String LibraryPlaylistImage) {
        this.LibraryPlaylistImage = LibraryPlaylistImage;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

}

