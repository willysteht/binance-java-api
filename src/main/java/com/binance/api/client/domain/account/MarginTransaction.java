package com.binance.api.client.domain.account;

import com.binance.api.client.ToStringBuilder;
import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * MarginTransaction information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginTransaction {

  private String tranId;

  public String getTranId() {
    return tranId;
  }

  public void setTranId(String tranId) {
    this.tranId = tranId;
  }

  @Override
  public String toString() {
    return new ToStringBuilder()
        .append("transactionId", tranId)
        .toString();
  }
}
