package com.binance.api.examples;

import com.binance.api.client.BinanceApiSwapRestClient;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceSpotApiClientFactory;

import java.util.List;

public class SwapEndpointExample {

    public static void main(String[] args) {
        BinanceSpotApiClientFactory factory = BinanceAbstractFactory.createSpotFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiSwapRestClient swapClient = factory.newSwapRestClient();
        List<Pool> pools = swapClient.listAllSwapPools();
        for (Pool pool : pools) {
            System.out.println(pool);
            Liquidity poolLiquidityInfo = swapClient.getPoolLiquidityInfo(pool.getPoolId());
            System.out.println(poolLiquidityInfo);
        }
        SwapQuote swapQuote = swapClient.requestQuote("USDT", "USDC", "10");
        System.out.println(swapQuote);
        SwapRecord swapRecord = swapClient.swap("USDT", "USDC", "10");
        SwapHistory swapHistory = swapClient.getSwapHistory(swapRecord.getSwapId());
        System.out.println(swapHistory);
    }
}
