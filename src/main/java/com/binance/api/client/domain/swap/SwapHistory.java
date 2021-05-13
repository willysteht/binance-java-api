package com.binance.api.client.domain.swap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
    "swapId": 2314,
    "swapTime": 1565770342148,
    "status": 0, // 0: pending, 1: success, 2: failed
    "quoteAsset": "USDT",
    "baseAsset": "BUSD",
    "quoteQty": 300000,
    "baseQty": 299975,
    "price": 1.00008334,
    "fee": 120
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapHistory {
    @JsonProperty("swapId")
    private Long swapId;
    @JsonProperty("swapTime")
    private Long swapTime;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("quoteAsset")
    private String quoteAsset;
    @JsonProperty("baseAsset")
    private String baseAsset;
    @JsonProperty("quoteQty")
    private double quoteQty;
    @JsonProperty("baseQty")
    private double baseQty;
    @JsonProperty("price")
    private double price;
    @JsonProperty("fee")
    private double fee;

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public double getPrice() {
        return price;
    }

    public double getBaseQty() {
        return baseQty;
    }

    public double getFee() {
        return fee;
    }

    public double getQuoteQty() {
        return quoteQty;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getSwapTime() {
        return swapTime;
    }

    public Long getSwapId() {
        return swapId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public void setBaseQty(double baseQty) {
        this.baseQty = baseQty;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public void setQuoteQty(double quoteQty) {
        this.quoteQty = quoteQty;
    }

    public void setSwapId(Long swapId) {
        this.swapId = swapId;
    }

    public void setSwapTime(Long swapTime) {
        this.swapTime = swapTime;
    }

    @Override
    public String toString() {
        return "SwapHistory{" +
                "quoteQty='" + quoteQty + '\'' +
                ", swapTime=" + swapTime +
                ", swapId='" + swapId + '\'' +
                ", price='" + price + '\'' +
                ", fee='" + fee + '\'' +
                ", baseQty='" + baseQty + '\'' +
                ", baseAsset='" + baseAsset + '\'' +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
