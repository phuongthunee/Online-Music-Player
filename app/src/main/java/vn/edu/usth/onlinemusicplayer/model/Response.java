package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    @SerializedName("Success")
    private String Success;

    @SerializedName("Message")
    private String Message;


    public String getSuccess() {
        return Success;
    }

    public String getMessage() {
        return Message;
    }

}