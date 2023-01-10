package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Singer implements Serializable {
    @SerializeName("SingerName")
    @Expose
    private String SingerName;
    @SerializeName("SingerId")
    @Expose
    private String SingerId;
    @SerializedName ("SingerImage")
    @Expose
    private String SingerImage;


    private String getSingerId() {
        return SingerId;
    }
    public void setSingerId(String SingerId){
        this.SingerId = SingerId;
    }
    public String getSingerName(){
        return SingerName;
    }
    public void setName (String SingerName){
        this.SingerName = SingerName;
    }
    public String SingerImage() {
        return SingerImage;
    }
    public void setSingerImage(String SingerImage) {
        this.SingerImage = SingerImage;
    }
}
