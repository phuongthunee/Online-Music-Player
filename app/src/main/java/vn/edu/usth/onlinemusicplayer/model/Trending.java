package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trending  implements Serializable {
    @SerializedName ("TrendingId")
    @Expose
    private String TrendingId;
    @SerializedName ("TrendingName")
    @Expose
    private String TrendingName;
    @SerializedName("TrendingImage")
    @Expose
    private String TrendingImage;

    public String getTrendingId() {
        return TrendingId;
    }

    public void setTrendingId(String TrendingId) {
        this.TrendingId = TrendingId;
    }

    public String getTrendingName() {
        return TrendingName;
    }

    public void setTrendingName(String TrendingName) {
        this.TrendingName = TrendingName;
    }

    public String getTrendingImage() {
        return TrendingImage;
    }

    public void setTrendingImage(String TrendingImage) {
        this.TrendingImage = TrendingImage;
    }

}
