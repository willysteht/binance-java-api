package com.binance.api.examples.testnet;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.account.LeverageRequest;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples binance futures account information
 */
public class TestnetLeverageMarginChange {
    private static final String SYMBOL = "BTCUSDT";
    private static final String API_KEY = "c8be940e7d3ebbfe79842236d6110b88e8350059ca48593a4809bc02794b837b";
    private static final String SECRET_KEY = "44090bdaf2e1b4d9f46bb772bc630ace9c3a00c3294ab61315f1c0e817ba29d6";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient client = factory.newRestClient();

        System.out.println("Current leverage : " + client.getAccount().getPosition(SYMBOL).getLeverage());

        client.changeInitialLeverage(new LeverageRequest(SYMBOL, 25));

        System.out.println("New leverage : " + client.getAccount().getPosition(SYMBOL).getLeverage());
    }

}
