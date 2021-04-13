package com.binance.api.client.domain.account;

import com.binance.api.client.ToStringBuilder;
import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * A withdraw that was done to a Binance account.
  *         "address": "0x94df8b352de7f46f64b01d3666bf6e936e44ce60",
  *         "amount": "8.91000000",
  *         "applyTime": "2019-10-12 11:12:02",
  *         "coin": "USDT",
  *         "id": "b6ae22b3aa844210a7041aee7589627c",
  *         "withdrawOrderId": "WITHDRAWtest123", // will not be returned if there's no withdrawOrderId for this withdraw.
  *         "network": "ETH",
  *         "transferType": 0,   // 1 for internal transfer, 0 for external transfer
  *         "status": 6,
  *         "txId": "0xb5ef8c13b968a406cc62a93a8bd80f9e9a906ef1b3fcf20a2e48573c17659268"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Withdraw {

  /**
   * Destination address.
   */
  private String address;
  /**
   * Amount withdrawn.
   */
  private String amount;

  private String applyTime;
  /**
   * Symbol.
   */
  private String coin;
  /**
   * Id.
   */
  private String id;

  private String withdrawOrderId;

  private String successTime;
  private String network;
  /**
   * (0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
   */
  private int status;

  /**
   * Transaction id.
   */
  private String txId;


  public String getNetwork() {
    return network;
  }

  public String getCoin() {
    return coin;
  }

  public String getWithdrawOrderId() {
    return withdrawOrderId;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public void setCoin(String coin) {
    this.coin = coin;
  }

  public void setWithdrawOrderId(String withdrawOrderId) {
    this.withdrawOrderId = withdrawOrderId;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAsset() {
    return coin;
  }

  public void setAsset(String asset) {
    this.coin = asset;
  }

  public String getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(String applyTime) {
    this.applyTime = applyTime;
  }

  public String getSuccessTime() {
    return successTime;
  }

  public void setSuccessTime(String successTime) {
    this.successTime = successTime;
  }

  public String getTxId() {
    return txId;
  }

  public void setTxId(String txId) {
    this.txId = txId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return new ToStringBuilder()
        .append("amount", amount)
        .append("address", address)
        .append("asset", coin)
        .append("applyTime", applyTime)
        .append("successTime", successTime)
        .append("txId", txId)
        .append("id", id)
        .append("status", status)
        .toString();
  }
}
