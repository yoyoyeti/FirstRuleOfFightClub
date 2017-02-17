package com.teambro.firstruleoffightclub.models;

import org.springframework.data.annotation.Id;

/**
 * Created by zac on 1/22/17.
 */
public class CustomURL {
    @Id
    private String id;

    private String customURL;
    private String redirectURL;
    private int clicks;

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public CustomURL() {
        this.clicks = 0;
    }

    public CustomURL(String customURL, String redirectURL) {
        this.clicks = 0;
        this.customURL = customURL;
        this.redirectURL = redirectURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomURL() {
        return customURL;
    }

    public void setCustomURL(String customURL) {
        this.customURL = customURL;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }
}
