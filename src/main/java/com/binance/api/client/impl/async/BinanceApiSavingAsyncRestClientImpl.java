package com.binance.api.client.impl.async;

import com.binance.api.client.api.BinanceApiCallback;
import com.binance.api.client.api.BinanceApiService;
import com.binance.api.client.api.BinanceSavingApiService;
import com.binance.api.client.api.async.BinanceApiSavingAsyncRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.saving.InterestHistory;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.saving.RedemptionRecord;
import com.binance.api.client.impl.BinanceApiCallbackAdapter;
import com.binance.api.client.impl.BinanceApiServiceGenerator;

import java.util.List;

public class BinanceApiSavingAsyncRestClientImpl implements BinanceApiSavingAsyncRestClient {

    private final BinanceSavingApiService binanceApiService;

    public BinanceApiSavingAsyncRestClientImpl(String apiKey, String secret, String apiUrl)
    {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceSavingApiService.class, apiKey, secret, apiUrl);
    }


    @Override
    public void getRedemptionRecord(String lendingType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow, Long timestamp, BinanceApiCallback<List<RedemptionRecord>> callback) {
        binanceApiService.getRedemptionRecord(lendingType, asset,startTime,endTime,current,size,recvWindow,timestamp)
                .enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPurchaseRecord(String lendingType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow, Long timestamp, BinanceApiCallback<List<PurchaseRecord>> callback) {
        binanceApiService.getPurchaseRecord(lendingType, asset,startTime,endTime,current,size,recvWindow,timestamp)
                .enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInterestHistory(String lendingType, String asset, Long startTime, Long endTime, Long current, Long size, Long recvWindow, Long timestamp, BinanceApiCallback<List<InterestHistory>> callback) {
        binanceApiService.getInterestHistory(lendingType, asset,startTime,endTime,current,size,recvWindow,timestamp)
                .enqueue(new BinanceApiCallbackAdapter<>(callback));
    }
}
