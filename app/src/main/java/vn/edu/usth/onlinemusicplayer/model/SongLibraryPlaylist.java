package vn.edu.usth.onlinemusicplayer.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SongLibraryPlaylist implements Parcelable {

    @SerializedName ("SongLibraryPlaylistId")
    @Expose
    private int SongLibraryPlaylistId;
    @SerializedName ("LibraryPlaylistId")
    @Expose
    private int LibraryPlaylistId;

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

    public SongLibraryPlaylistModel(int SongLibraryPlaylistId, int LibraryPlaylistId, int SongId,
                                      String SongName, String SongImage, String SingerName, String SongLink) {
        this.SongLibraryPlaylistId = SongLibraryPlaylistId;
        this.LibraryPlaylistId = LibraryPlaylistId;
        this.SongId = SongId;
        this.SongName = SongName;
        this.SongImage = SongImage;
        this.SingerName = SingerName;
        this.SongLink = SongLink;
    }


    protected SongLibraryPlaylistModel(Parcel in) {
        SongLibraryPlaylistId = in.readInt();
        LibraryPlaylistId = in.readInt();
        SongId = in.readInt();
        SongName = in.readString();
        SongImage = in.readString();
        SingerName = in.readString();
        SongLink = in.readString();
    }

    public int getSongLibraryPlaylistId() {
        return SongLibraryPlaylistId;
    }

    public void setIdBaiHatThuVienPlayList(int SongLibraryPlaylistId) {
        this.SongLibraryPlaylistId = SongLibraryPlaylistId;
    }

    public int getIdThuVienPlayList() {
        return LibraryPlaylistId;
    }

    public void setIdThuVienPlayList(int idThuVienPlayList) {
        this.LibraryPlaylistId = LibraryPlaylistId;
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

    public void setSongImage (String SongImage) {
        this.SongImage = SongImage;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName (String SingerName) {
        this.SingerName = SingerName;
    }

    public String getSongLink() {
        return SongLink;
    }

    public void setSongLink(String SongLink) {
        this.SongLink = SongLink;
    }

    public static final Creator<SongLibraryPlayListModel> CREATOR = new Creator<SongLibraryPlayListModel>() {
        @Override
        public SongLibraryPlayListModel createFromParcel(Parcel in) {
            return new SongLibraryPlayListModel(in);
        }

        @Override
        public SongLibraryPlayListModel[] newArray(int size) {
            return new SongLibraryPlayListModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(SongLibraryPlaylistId);
        dest.writeInt(LibraryPlaylistId);
        dest.writeInt(SongId);
        dest.writeString(SongName);
        dest.writeString(SongImage);
        dest.writeString(SingerName);
        dest.writeString(SongLink);
    }

}
