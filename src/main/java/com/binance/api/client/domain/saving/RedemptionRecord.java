package com.binance.api.client.domain.saving;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Response:
    Flexible Products
[
    {
        "amount": "10.54000000",
        "asset": "USDT",
        "createTime": 1577257222000,
        "principal": "10.54000000",
        "projectId": "USDT001",
        "projectName": "USDT",
        "status": "PAID",
        "type": "FAST"
     }
]
    Fixed/Activity Products
[
    {
        "amount": "0.07070000",
        "asset": "USDT",
        "createTime": 1566200161000,
        "interest": "0.00070000",
        "principal": "0.07000000",
        "projectId": "test06",
        "projectName": "USDT 1 day (10% anniualized)",
        "startTime": 1566198000000,
        "status": "PAID"
     }
]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedemptionRecord {
    @JsonProperty("amount")
    String amount;
    @JsonProperty("asset")
    String asset;
    @JsonProperty("createTime")
    Long createTime;
    @JsonProperty("interest")
    Double interest;
    @JsonProperty("principal")
    Double principal;
    @JsonProperty("projectId")
    String projectId;
    @JsonProperty("projectName")
    String projectName;
    @JsonProperty("status")
    String status;

    public String getAmount() {
        return amount;
    }

    public String getAsset() {
        return asset;
    }

    public String getStatus() {
        return status;
    }

    public Double getInterest() {
        return interest;
    }

    public Double getPrincipal() {
        return principal;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
