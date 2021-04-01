package com.binance.api.examples.futures;

import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples binance futures account information
 */
public class FuturesAccountExample {
    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createFuturesFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiFuturesRestClient client = factory.newFuturesRestClient();

        FuturesAccount account = client.getAccount();
        System.out.println("Available Balance: " + account.getAvailableBalance());
    }

}
