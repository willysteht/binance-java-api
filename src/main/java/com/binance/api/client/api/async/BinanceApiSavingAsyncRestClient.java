package com.binance.api.client.api.async;

import com.binance.api.client.api.BinanceApiCallback;
import com.binance.api.client.domain.account.Liquidity;
import com.binance.api.client.domain.saving.InterestHistory;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.saving.RedemptionRecord;

import java.util.List;

public interface BinanceApiSavingAsyncRestClient {

    void getRedemptionRecord (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp,
            BinanceApiCallback<List<RedemptionRecord>> callback);

    void getPurchaseRecord (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp,
            BinanceApiCallback<List<PurchaseRecord>> callback
    );

    void getInterestHistory (
            String lendingType,
            String asset,
            Long startTime,
            Long endTime,
            Long current,
            Long size,
            Long recvWindow,
            Long timestamp,
            BinanceApiCallback<List<InterestHistory>> callback
    );
}
