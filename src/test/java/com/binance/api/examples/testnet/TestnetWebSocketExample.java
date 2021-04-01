package com.binance.api.examples.testnet;

import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Example binance futures websocket connection
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetWebSocketExample {
    private static final String SYMBOL = "LTCUSDT";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory factory = BinanceAbstractFactory.createTestnetFactory();
        BinanceApiWebSocketClient webSocketClient = factory.newWebSocketClient();

//        webSocketClient.onTickerEvent(SYMBOL, System.out::println);
        webSocketClient.onCandlestickEvent(SYMBOL, CandlestickInterval.ONE_MINUTE, System.out::println);
    }

}
