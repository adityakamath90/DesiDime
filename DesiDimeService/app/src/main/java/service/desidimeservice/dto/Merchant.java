package service.desidimeservice.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Merchant implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("recommendation")
    @Expose
    private String recommendation;
    @SerializedName("recommendation_flag")
    @Expose
    private Boolean recommendationFlag;
    @SerializedName("average_rating")
    @Expose
    private String averageRating;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return The permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * @param permalink The permalink
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     * @return The recommendation
     */
    public String getRecommendation() {
        return recommendation;
    }

    /**
     * @param recommendation The recommendation
     */
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * @return The recommendationFlag
     */
    public Boolean getRecommendationFlag() {
        return recommendationFlag;
    }

    /**
     * @param recommendationFlag The recommendation_flag
     */
    public void setRecommendationFlag(Boolean recommendationFlag) {
        this.recommendationFlag = recommendationFlag;
    }

    /**
     * @return The averageRating
     */
    public String getAverageRating() {
        return averageRating;
    }

    /**
     * @param averageRating The average_rating
     */
    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.image);
        dest.writeString(this.permalink);
        dest.writeString(this.recommendation);
        dest.writeValue(this.recommendationFlag);
        dest.writeString(this.averageRating);
    }

    public Merchant() {
    }

    protected Merchant(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.image = in.readString();
        this.permalink = in.readString();
        this.recommendation = in.readString();
        this.recommendationFlag = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.averageRating = in.readString();
    }

    public static final Parcelable.Creator<Merchant> CREATOR = new Parcelable.Creator<Merchant>() {
        public Merchant createFromParcel(Parcel source) {
            return new Merchant(source);
        }

        public Merchant[] newArray(int size) {
            return new Merchant[size];
        }
    };
}