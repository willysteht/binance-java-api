package com.binance.api.client.api;

import com.binance.api.client.constant.BinanceApiConstants;


/**
 * Binance API error object.
 */
public class BinanceApiError {

  /**
   * Error code.
   */
  private int code;

  /**
   * Error message.
   */
  private String msg;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return new ToStringBuilder()
        .append("code", code)
        .append("msg", msg)
        .toString();
  }
}
