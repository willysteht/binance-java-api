package com.binance.api.client.domain.account.snapshot;

import com.binance.api.client.domain.account.snapshot.data.IData;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class SnapshotVos<T extends IData> {
    public T data;
    @JsonDeserialize(using = DailyAccountSnapshotTypeDeserializer.class)
    public DailyAccountSnapshotTypes type;
    public long updateTime;
}
