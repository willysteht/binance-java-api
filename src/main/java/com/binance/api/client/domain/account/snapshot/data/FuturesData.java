package com.binance.api.client.domain.account.snapshot.data;

import com.binance.api.client.domain.account.snapshot.FuturesSnapshotAsset;
import com.binance.api.client.domain.account.snapshot.FuturesSnapshotPosition;

import java.util.List;

public class FuturesData implements IData {
    public List<FuturesSnapshotAsset> assets;
    public List<FuturesSnapshotPosition> position;
}
