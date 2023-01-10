package vn.edu.usth.onlinemusicplayer.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Topic implements Serializable {
    @SerializedName("TopicId")
    @Expose
    private String TopicId;
    @SerializedName("TopicName")
    @Expose
    private String TopicName;
    @SerializedName("TopicImage")
    @Expose
    private String TopicImage;

    public String getTopicId() {
        return TopicId;
    }

    public void setTopicId(String TopicId) {
        this.TopicId = TopicId;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String TopicName) {
        this.TopicName = TopicName;
    }

    public String getTopicImage() {
        return TopicImage;
    }

    public void setTopicImage(String TopicImage) {
        this.TopicImage = TopicImage;
    }

}
