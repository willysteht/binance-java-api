package com.binance.api.client.domain.account.request;

import com.binance.api.client.ToStringBuilder;
import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Response object returned when an order is canceled.
 *
 * @see CancelOrderRequest for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelOrderResponse {

  private String symbol;

  private String origClientOrderId;

  private String orderId;

  private String clientOrderId;

  private String status;
  private String executedQty;

  public String getSymbol() {
    return symbol;
  }

  public CancelOrderResponse setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public String getOrigClientOrderId() {
    return origClientOrderId;
  }

  public CancelOrderResponse setOrigClientOrderId(String origClientOrderId) {
    this.origClientOrderId = origClientOrderId;
    return this;
  }

  public String getStatus() {
    return status;
  }
  public String getExecutedQty() {
    return executedQty;
  }

  public String getOrderId() {
    return orderId;
  }
  public CancelOrderResponse setOrderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public CancelOrderResponse setClientOrderId(String clientOrderId) {
    this.clientOrderId = clientOrderId;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder()
        .append("symbol", symbol)
        .append("origClientOrderId", origClientOrderId)
        .append("orderId", orderId)
        .append("clientOrderId", clientOrderId)
        .toString();
  }
}
