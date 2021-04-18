package com.binance.api.client.domain.account;

import com.binance.api.client.ToStringBuilder;
import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * A deposit that was done to a Binance account.
 * *          "amount":"0.00999800",
 *  *         "coin":"PAXG",
 *  *         "network":"ETH",
 *  *         "status":1,
 *  *         "address":"0x788cabe9236ce061e5a892e1a59395a81fc8d62c",
 *  *         "addressTag":"",
 *  *         "txId":"0xaad4654a3234aa6118af9b4b335f5ae81c360b2394721c019b5d1e75328b09f3",
 *  *         "insertTime":1599621997000,
 *  *         "transferType":0,
 *  *         "confirmTimes":"12/12"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit {

  /**
   * Amount deposited.
   */
  private String amount;

  /**
   * Symbol.
   */
  private String coin;

  private String network;
  /**
   * (0:pending,1:success)
   */
  private Integer status;
  private String address;
  private String addressTag;
  /**
   * Transaction id
   */
  private String txId;

  /**
   * Deposit time.
   */
  private String insertTime;
  private Integer transferType;
  private String confirmTimes;

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getTransferType() {
    return transferType;
  }

  public String getAddress() {
    return address;
  }

  public String getAddressTag() {
    return addressTag;
  }

  public String getCoin() {
    return coin;
  }

  public String getConfirmTimes() {
    return confirmTimes;
  }

  public String getNetwork() {
    return network;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setAddressTag(String addressTag) {
    this.addressTag = addressTag;
  }

  public void setCoin(String coin) {
    this.coin = coin;
  }

  public void setConfirmTimes(String confirmTimes) {
    this.confirmTimes = confirmTimes;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public void setTransferType(Integer transferType) {
    this.transferType = transferType;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getAsset() {
    return coin;
  }

  public void setAsset(String asset) {
    this.coin = asset;
  }

  public String getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(String insertTime) {
    this.insertTime = insertTime;
  }

  public String getTxId() {
    return txId;
  }

  public void setTxId(String txId) {
    this.txId = txId;
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
        .append("asset", coin)
        .append("insertTime", insertTime)
        .append("txId", txId)
        .append("status", status)
        .toString();
  }
}
