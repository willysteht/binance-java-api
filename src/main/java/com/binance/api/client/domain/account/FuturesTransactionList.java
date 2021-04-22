package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesTransactionList {

    @JsonProperty("rows")
    private List<FuturesTransactionHistory> rows;

    @JsonProperty("total")
    private long total;

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setRows(List<FuturesTransactionHistory> rows) {
        this.rows = rows;
    }

    public List<FuturesTransactionHistory> getRows() {
        return rows;
    }
}
