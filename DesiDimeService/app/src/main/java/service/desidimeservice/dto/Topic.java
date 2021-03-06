package service.desidimeservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fpd_flag")
    @Expose
    private Boolean fpdFlag;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("view_count")
    @Expose
    private String viewCount;
    @SerializedName("posts_count")
    @Expose
    private String postsCount;
    @SerializedName("last_activity_at")
    @Expose
    private String lastActivityAt;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("forum_name")
    @Expose
    private String forumName;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("front_page_suggestions_count")
    @Expose
    private String frontPageSuggestionsCount;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = new ArrayList<Object>();
    @SerializedName("merchant")
    @Expose
    private Merchant__ merchant;
    @SerializedName("user")
    @Expose
    private User user;

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
     * @return The fpdFlag
     */
    public Boolean getFpdFlag() {
        return fpdFlag;
    }

    /**
     * @param fpdFlag The fpd_flag
     */
    public void setFpdFlag(Boolean fpdFlag) {
        this.fpdFlag = fpdFlag;
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
     * @return The viewCount
     */
    public String getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount The view_count
     */
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return The postsCount
     */
    public String getPostsCount() {
        return postsCount;
    }

    /**
     * @param postsCount The posts_count
     */
    public void setPostsCount(String postsCount) {
        this.postsCount = postsCount;
    }

    /**
     * @return The lastActivityAt
     */
    public String getLastActivityAt() {
        return lastActivityAt;
    }

    /**
     * @param lastActivityAt The last_activity_at
     */
    public void setLastActivityAt(String lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
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
     * @return The forumName
     */
    public String getForumName() {
        return forumName;
    }

    /**
     * @param forumName The forum_name
     */
    public void setForumName(String forumName) {
        this.forumName = forumName;
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
     * @return The frontPageSuggestionsCount
     */
    public String getFrontPageSuggestionsCount() {
        return frontPageSuggestionsCount;
    }

    /**
     * @param frontPageSuggestionsCount The front_page_suggestions_count
     */
    public void setFrontPageSuggestionsCount(String frontPageSuggestionsCount) {
        this.frontPageSuggestionsCount = frontPageSuggestionsCount;
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
    public Merchant__ getMerchant() {
        return merchant;
    }

    /**
     * @param merchant The merchant
     */
    public void setMerchant(Merchant__ merchant) {
        this.merchant = merchant;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

}