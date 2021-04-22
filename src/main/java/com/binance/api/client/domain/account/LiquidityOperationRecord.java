package com.binance.api.client.domain.account;

import com.binance.api.client.domain.LiquidityOperationRecordStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
        "operationId": 12341,
        "poolId": 2,
        "poolName": "BUSD/USDT",
        "operation": "ADD", // "ADD" or "REMOVE"
        "status": 1, // 0: pending, 1: success, 2: failed
        "updateTime": 1565769342148,
        "shareAmount": "10.1"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiquidityOperationRecord {
    @JsonProperty("operationId")
    private Long operationId;
    @JsonProperty("poolId")
    private Long poolId;
    @JsonProperty("poolName")
    private String poolName;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("status")
    private LiquidityOperationRecordStatus status;
    @JsonProperty("updateTime")
    private Long updateTime;
    @JsonProperty("shareAmount")
    private String shareAmount;



    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(String shareAmount) {
        this.shareAmount = shareAmount;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public LiquidityOperationRecordStatus getStatus() {
        return status;
    }

    public void setStatus(LiquidityOperationRecordStatus status) {
        this.status = status;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    @Override
    public String toString() {
        return "LiquidityOperationRecord{" +
                "poolId='" + poolId + '\'' +
                ", operationId='" + operationId + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", operation='" + operation + '\'' +
                ", shareAmount='" + shareAmount + '\'' +
                ", poolName='" + poolName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
