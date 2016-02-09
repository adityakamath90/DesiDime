package service.desidimeservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Merchant {

    @SerializedName("id")
    @Expose
    private Integer id;
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
    private Integer recommendation;
    @SerializedName("recommendation_flag")
    @Expose
    private Boolean recommendationFlag;
    @SerializedName("average_rating")
    @Expose
    private String averageRating;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
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
    public Integer getRecommendation() {
        return recommendation;
    }

    /**
     * @param recommendation The recommendation
     */
    public void setRecommendation(Integer recommendation) {
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

}