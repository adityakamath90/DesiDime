package service.desidimeservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Coupon {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("coupon_type")
    @Expose
    private String couponType;
    @SerializedName("coupon_detail")
    @Expose
    private String couponDetail;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("coupon_url")
    @Expose
    private String couponUrl;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("redemption_count")
    @Expose
    private Integer redemptionCount;
    @SerializedName("vote_value")
    @Expose
    private String voteValue;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("mobile_verification_required")
    @Expose
    private Boolean mobileVerificationRequired;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = new ArrayList<Object>();
    @SerializedName("merchant")
    @Expose
    private Merchant_ merchant;

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
     * @return The couponType
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * @param couponType The coupon_type
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    /**
     * @return The couponDetail
     */
    public String getCouponDetail() {
        return couponDetail;
    }

    /**
     * @param couponDetail The coupon_detail
     */
    public void setCouponDetail(String couponDetail) {
        this.couponDetail = couponDetail;
    }

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The couponUrl
     */
    public String getCouponUrl() {
        return couponUrl;
    }

    /**
     * @param couponUrl The coupon_url
     */
    public void setCouponUrl(String couponUrl) {
        this.couponUrl = couponUrl;
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
     * @return The redemptionCount
     */
    public Integer getRedemptionCount() {
        return redemptionCount;
    }

    /**
     * @param redemptionCount The redemption_count
     */
    public void setRedemptionCount(Integer redemptionCount) {
        this.redemptionCount = redemptionCount;
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
     * @return The expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate The expiry_date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return The createdAt
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The mobileVerificationRequired
     */
    public Boolean getMobileVerificationRequired() {
        return mobileVerificationRequired;
    }

    /**
     * @param mobileVerificationRequired The mobile_verification_required
     */
    public void setMobileVerificationRequired(Boolean mobileVerificationRequired) {
        this.mobileVerificationRequired = mobileVerificationRequired;
    }

    /**
     * @return The categories
     */
    public List<Object> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    /**
     * @return The merchant
     */
    public Merchant_ getMerchant() {
        return merchant;
    }

    /**
     * @param merchant The merchant
     */
    public void setMerchant(Merchant_ merchant) {
        this.merchant = merchant;
    }

}