package com.binance.api.client.domain.account.snapshot.data;

import com.binance.api.client.domain.account.AssetBalance;

import java.util.List;

public class SpotData implements IData {
    public List<AssetBalance> balances;
    public String totalAssetOfBtc;
}
