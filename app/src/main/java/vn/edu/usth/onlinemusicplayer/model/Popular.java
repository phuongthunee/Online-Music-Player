package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Popular implements Serializable {
    @SerializedName("PopularId")
    @Expose
    private String PopularId;
    @SerializedName("PopularName")
    @Expose
    private String PopularName;
    @SerializedName("PopularImage")
    @Expose
    private String PopularImage;

    public String getPopularId() {
        return PopularId;
    }

    public void setPopularId(String PopularId) {
        this.PopularId = PopularId;
    }

    public String getPopularName() {
        return PopularName;
    }

    public void setPopularName(String PopularName) {
        this.PopularName = PopularName;
    }

    public String getPopularImage() {
        return PopularImage;
    }

    public void setPopularImage(String PopularImage) {
        this.PopularImage = PopularImage;
    }

}
