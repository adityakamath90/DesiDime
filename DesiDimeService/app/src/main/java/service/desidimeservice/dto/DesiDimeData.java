package service.desidimeservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DesiDimeData {

    @SerializedName("deals")
    @Expose
    private List<Deal> deals = new ArrayList<Deal>();
    @SerializedName("coupons")
    @Expose
    private List<Coupon> coupons = new ArrayList<Coupon>();
    @SerializedName("topics")
    @Expose
    private List<Topic> topics = new ArrayList<Topic>();

    /**
     * @return The deals
     */
    public List<Deal> getDeals() {
        return deals;
    }

    /**
     * @param deals The deals
     */
    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    /**
     * @return The coupons
     */
    public List<Coupon> getCoupons() {
        return coupons;
    }

    /**
     * @param coupons The coupons
     */
    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    /**
     * @return The topics
     */
    public List<Topic> getTopics() {
        return topics;
    }

    /**
     * @param topics The topics
     */
    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

}