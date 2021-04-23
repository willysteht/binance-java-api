package com.binance.api.client.domain.saving;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
[
    {
        "asset": "BUSD",
        "interest": "0.00006408",
        "lendingType": "DAILY",
        "productName": "BUSD",
        "time": 1577233578000
    },
    {
        "asset": "USDT",
        "interest": "0.00687654",
        "lendingType": "DAILY",
        "productName": "USDT",
        "time": 1577233562000
    }
]

 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterestHistory {
    @JsonProperty("asset")
    String asset;
    @JsonProperty("interest")
    Double interest;
    @JsonProperty("lendingType")
    String lendingType;
    @JsonProperty("productName")
    String productName;
    @JsonProperty("time")
    Long time;

    public Double getInterest() {
        return interest;
    }

    public String getAsset() {
        return asset;
    }

    public String getProductName() {
        return productName;
    }

    public Long getTime() {
        return time;
    }

    public String getLendingType() {
        return lendingType;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setLendingType(String lendingType) {
        this.lendingType = lendingType;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
