package service.desidimeservice.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deal implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("off_percent")
    @Expose
    private String offPercent;
    @SerializedName("current_price")
    @Expose
    private String currentPrice;
    @SerializedName("original_price")
    @Expose
    private String originalPrice;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("comments_count")
    @Expose
    private String commentsCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("vote_value")
    @Expose
    private String voteValue;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("deal_url")
    @Expose
    private String dealUrl;
    @SerializedName("merchant")
    @Expose
    private Merchant merchant;

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
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The offPercent
     */
    public String getOffPercent() {
        return offPercent;
    }

    /**
     * @param offPercent The off_percent
     */
    public void setOffPercent(String offPercent) {
        this.offPercent = offPercent;
    }

    /**
     * @return The currentPrice
     */
    public String getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @param currentPrice The current_price
     */
    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * @return The originalPrice
     */
    public String getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice The original_price
     */
    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
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
     * @return The commentsCount
     */
    public String getCommentsCount() {
        return commentsCount;
    }

    /**
     * @param commentsCount The comments_count
     */
    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * @return The voteValue
     */
    public String getVoteValue() {
        return voteValue;
    }

    /**
     * @param voteValue The vote_value
     */
    public void setVoteValue(String voteValue) {
        this.voteValue = voteValue;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The shareUrl
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * @param shareUrl The share_url
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    /**
     * @return The dealUrl
     */
    public String getDealUrl() {
        return dealUrl;
    }

    /**
     * @param dealUrl The deal_url
     */
    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl;
    }

    /**
     * @return The merchant
     */
    public Merchant getMerchant() {
        return merchant;
    }

    /**
     * @param merchant The merchant
     */
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.offPercent);
        dest.writeString(this.currentPrice);
        dest.writeString(this.originalPrice);
        dest.writeString(this.image);
        dest.writeString(this.commentsCount);
        dest.writeString(this.createdAt);
        dest.writeString(this.score);
        dest.writeString(this.voteValue);
        dest.writeString(this.description);
        dest.writeString(this.shareUrl);
        dest.writeString(this.dealUrl);
        dest.writeParcelable(this.merchant, flags);
    }

    public Deal() {
    }

    protected Deal(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.offPercent = in.readString();
        this.currentPrice = in.readString();
        this.originalPrice = in.readString();
        this.image = in.readString();
        this.commentsCount = in.readString();
        this.createdAt = in.readString();
        this.score = in.readString();
        this.voteValue = in.readString();
        this.description = in.readString();
        this.shareUrl = in.readString();
        this.dealUrl = in.readString();
        this.merchant = in.readParcelable(Merchant.class.getClassLoader());
    }

    public static final Parcelable.Creator<Deal> CREATOR = new Parcelable.Creator<Deal>() {
        public Deal createFromParcel(Parcel source) {
            return new Deal(source);
        }

        public Deal[] newArray(int size) {
            return new Deal[size];
        }
    };
}