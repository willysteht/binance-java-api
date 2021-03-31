package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.BinanceEngineType;
import com.binance.api.client.domain.account.FuturesAccount;

/**
 * Examples binance futures account information
 */
public class FuturesAccountExample {
    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiFuturesRestClient client = factory.newFuturesRestClient();

        FuturesAccount account = client.getAccount();
        System.out.println("Available Balance: " + account.getAvailableBalance());
    }

}
