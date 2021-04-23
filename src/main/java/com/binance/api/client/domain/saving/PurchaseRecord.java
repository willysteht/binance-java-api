package com.binance.api.client.domain.saving;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Response:
    Flexible Products
[
    {
        "amount": "100.00000000",
        "asset": "USDT",
        "createTime": 1575018510000,
        "lendingType": "DAILY",
        "productName": "USDT",
        "purchaseId": 26055,
        "status": "SUCCESS"
    }
]
    Fixed/Activity Products
[
    {
        "amount": "100.00000000",
        "asset": "USDT",
        "createTime": 1575018453000,
        "lendingType": "ACTIVITY",
        "lot": 1,
        "productName": "【Special】USDT 7D (8%)",
        "purchaseId": 36857,
        "status": "SUCCESS"
    }
]

 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseRecord {
    @JsonProperty("amount")
    String amount;
    @JsonProperty("asset")
    String asset;
    @JsonProperty("creatTime")
    Long creatTime;
    @JsonProperty("lot")
    Long lot;
    @JsonProperty("productName")
    String productName;
    @JsonProperty("purchaseId")
    Long purchaseId;
    @JsonProperty("status")
    String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public void setLot(Long lot) {
        this.lot = lot;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getStatus() {
        return status;
    }

    public String getAsset() {
        return asset;
    }

    public String getAmount() {
        return amount;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public Long getLot() {
        return lot;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public String getProductName() {
        return productName;
    }
}
