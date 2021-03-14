package com.binance.api.client.domain.account.request;

import com.binance.api.client.ToStringBuilder;
import com.binance.api.client.constant.BinanceApiConstants;


/**
 * A specialized order request with additional filters.
 */
public class AllOrdersRequest extends OrderRequest {

  private static final Integer DEFAULT_LIMIT = 500;

  private Long orderId;

  private Integer limit;

  public AllOrdersRequest(String symbol) {
    super(symbol);
    this.limit = DEFAULT_LIMIT;
  }

  public Long getOrderId() {
    return orderId;
  }

  public AllOrdersRequest orderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public Integer getLimit() {
    return limit;
  }

  public AllOrdersRequest limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder()
        .append("orderId", orderId)
        .append("limit", limit)
        .toString();
  }
}
