package com.binance.api.client.domain.account.snapshot;

import com.binance.api.client.domain.account.snapshot.data.IData;

public class SnapshotVos<T extends IData> {
    public T data;
    public DailyAccountSnapshotTypes type;
    public long updateTime;
}
