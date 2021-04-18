package com.binance.api.client.impl;

import com.binance.api.client.WalletEndpoint;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.Deposit;
import com.binance.api.client.domain.account.Withdraw;
import com.binance.api.client.impl.BinanceApiService;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.createService;
import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;

public class WalletEndPointImpl implements WalletEndpoint
{
    private final BinanceApiService binanceApiService;

    public WalletEndPointImpl(BinanceApiService binanceApiService) {
        this.binanceApiService = binanceApiService;
    }

    @Override
    public List<Deposit> getDepositHistory(String asset, Integer status, Long startTime, Long endTime, Integer offset, Integer limit)
    {
        return executeSync(binanceApiService.getDepositHistory(asset,status,startTime,endTime,offset,limit, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                System.currentTimeMillis()));
    }

    @Override
    public List<Deposit> getDepositHistory(String asset) {
        return getDepositHistory(asset,null,null,null,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(String asset,long startTime) {
        return getDepositHistory(asset,null,startTime,null,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(long endTime) {
        return getDepositHistory(null,null,null,endTime,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(long startTime,long endTime) {
        return getDepositHistory(null,null,startTime,endTime,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory(String asset,long startTime,long endTime) {
        return getDepositHistory(asset,null,startTime,endTime,null,null);
    }

    @Override
    public List<Deposit> getDepositHistory() {
        return getDepositHistory(null,null,null,null,null,null);
    }

    @Override
    public List<Withdraw> getWithdrawHistory(String asset) {
        return executeSync(binanceApiService.getWithdrawHistory(asset,null,null,null,null,null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                System.currentTimeMillis()));
    }

    @Override
    public List<Withdraw> getWithdrawHistory(long startTime, long endTime) {
        return executeSync(binanceApiService.getWithdrawHistory(null,null,startTime,endTime,null,null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW,
                System.currentTimeMillis()));
    }
}
