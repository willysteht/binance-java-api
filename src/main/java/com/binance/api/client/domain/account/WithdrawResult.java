package com.binance.api.client.domain.account;

import com.binance.api.client.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * A withdraw result that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawResult {

    /**
     * Withdraw message.
     */
    private String msg;

    /**
     * Withdraw success.
     */
    private boolean success;

    /**
     * Withdraw id.
     */
    private String id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder()
                .append("msg", msg)
                .append("success", success)
                .append("id", id)
                .toString();
    }


}
