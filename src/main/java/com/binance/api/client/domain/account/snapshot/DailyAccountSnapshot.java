package com.binance.api.client.domain.account.snapshot;

import com.binance.api.client.domain.account.snapshot.data.IData;
import com.binance.api.client.domain.market.CandleStickDeserializerMarket;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class DailyAccountSnapshot<T extends IData> {
    @JsonProperty("code")
    public int code;
    @JsonProperty("msg")
    public String msg;
    @JsonProperty("snapshotVos")
    @JsonDeserialize(using = CandleStickDeserializerMarket.class)
    public List<SnapshotVos<T>> snapshotVos;
}
