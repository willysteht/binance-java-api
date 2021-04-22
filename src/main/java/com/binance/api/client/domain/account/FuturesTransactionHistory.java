package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
{
  "rows": [
    {
      "asset": "USDT",
      "tranId": 100000001
      "amount": "40.84624400",
      "type": "1",  // one of 1( from spot to USDT-Ⓜ), 2( from USDT-Ⓜ to spot), 3( from spot to COIN-Ⓜ), and 4( from COIN-Ⓜ to spot)
      "timestamp": 1555056425000,
      "status": "CONFIRMED" //one of PENDING (pending to execution), CONFIRMED (successfully transfered), FAILED (execution failed, nothing happened to your account);
    }
  ],
  "total": 1
}

 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesTransactionHistory {
    @JsonProperty("asset")
    private String asset;
    @JsonProperty("tranId")
    private long tranId;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("status")
    private String status;

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setTranId(long tranId) {
        this.tranId = tranId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getTranId() {
        return tranId;
    }

    public String getAmount() {
        return amount;
    }

    public String getAsset() {
        return asset;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }
}
