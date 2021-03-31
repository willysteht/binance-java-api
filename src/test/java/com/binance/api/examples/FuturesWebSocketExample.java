package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.market.CandlestickInterval;

/**
 * Example binance futures websocket connection
 *
 * @author Mahdi Sheikh Hosseini
 */
public class FuturesWebSocketExample {
    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
        BinanceApiWebSocketClient webSocketClient = factory.newFuturesWebSocketClient();

//        webSocketClient.onTickerEvent(SYMBOL, System.out::println);
        webSocketClient.onCandlestickEvent(SYMBOL, CandlestickInterval.FIFTEEN_MINUTES, System.out::println);
    }

}
