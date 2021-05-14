package com.binance.api.client.domain.account.snapshot.data;

import com.binance.api.client.domain.account.MarginAssetBalance;

import java.util.List;

public class MarginData implements IData {
    public String marginLevel;
    public String totalAssetOfBtc;
    public String totalLiabilityOfBtc;
    public String totalNetAssetOfBtc;
    public List<MarginAssetBalance> userAssets;
}
