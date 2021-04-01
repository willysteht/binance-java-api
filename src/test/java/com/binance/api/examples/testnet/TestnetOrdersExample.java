package com.binance.api.examples.testnet;

import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.account.FuturesNewOrder;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples on how to place orders, cancel them.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetOrdersExample {
    private static final String SYMBOL = "BTCUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";


    public static void main(String[] args) throws InterruptedException {
        BinanceFuturesApiClientFactory testnetFactory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiWebSocketClient streamClient = testnetFactory.newWebSocketClient();
        BinanceApiFuturesRestClient restClient = testnetFactory.newFuturesRestClient();


        String listenKey = restClient.startUserDataStream();

        streamClient.onUserDataUpdateEvent(listenKey, System.out::println);
        System.out.println("Waiting for events...");


        BinanceApiFuturesRestClient futureClient = testnetFactory.newFuturesRestClient();
        FuturesNewOrderResponse response1 = futureClient.newOrder(FuturesNewOrder.MarketLong(SYMBOL, "1", false));
        System.out.println(response1.getStatus());


        Thread.sleep(5000);
        FuturesNewOrderResponse response2 = futureClient.newOrder(FuturesNewOrder.MarketShort(SYMBOL, "1", false));
        System.out.println(response2);
    }

}
