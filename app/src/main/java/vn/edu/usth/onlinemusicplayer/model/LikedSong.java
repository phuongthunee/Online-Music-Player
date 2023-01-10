package vn.edu.usth.onlinemusicplayer.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LikedSong implements Parcelable {
    @SerializedName("LikedId")
    @Expose
    private int LikedId;

    @SerializedName("UserName")
    @Expose
    private String Username;

    @SerializedName("SongId")
    @Expose
    private int SongId;

    @SerializedName("SongName")
    @Expose
    private String SongName;

    @SerializedName("SongImage")
    @Expose
    private String SongImage;

    @SerializedName("SingerName")
    @Expose
    private String SingerName;

    @SerializedName("SongLink")
    @Expose
    private String SongLink;

    public LikedSongModel(int LikedId, String Username, int SongId, String SongName, String SongImage, String SingerName, String SongLink) {
        this.LikedId = LikedId;
        this.Username = Username;
        this.SongId = SongId;
        this.SongName = SongName;
        this.SongImage = SongImage;
        this.SingerName = SingerName;
        this.SongLink = SongLink;
    }

    public int getLikedId() {
        return LikedId;
    }

    public void setLikedId(int LikedId) {
        this.LikedId = LikedId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = Username;
    }

    public int getSongId() {
        return SongId;
    }

    public void setSongId(int SongId) {
        this.SongId = SongId;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String SongName) {
        this.SongName = SongName;
    }

    public String getSongImage() {
        return SongImage;
    }

    public void setSongImage(String SongImage) {
        this.SongImage = SongImage;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String SingerName) {
        this.SingerName = SingerName;
    }

    public String getSongLink() {
        return SongLink;
    }

    public void setSongLink(String SongLink) {
        this.SongLink = SongLink;
    }

    protected LikedSongModel(Parcel in) {
        LikedId = in.readInt();
        Username = in.readString();
        SongId = in.readInt();
        SongName = in.readString();
        SongImage = in.readString();
        SingerName = in.readString();
        SongLink = in.readString();
    }

    public static final Creator<LikedSong> CREATOR = new Creator<LikedSong>() {
        @Override
        public LikedSong createFromParcel(Parcel in) {
            return new LikedSong(in);
        }

        @Override
        public LikedSong[] newArray(int size) {
            return new LikedSong[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(LikedId);
        dest.writeString(Username);
        dest.writeInt(SongId);
        dest.writeString(SongName);
        dest.writeString(SongImage);
        dest.writeString(SingerName);
        dest.writeString(SongLink);
    }

}
