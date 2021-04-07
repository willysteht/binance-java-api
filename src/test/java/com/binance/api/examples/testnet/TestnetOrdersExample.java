package com.binance.api.examples.testnet;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

/**
 * Examples on how to place orders, cancel them.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetOrdersExample {
    private static final String SYMBOL = "BTCUSDT";
    private static final String API_KEY = "c8be940e7d3ebbfe79842236d6110b88e8350059ca48593a4809bc02794b837b";
    private static final String SECRET_KEY = "44090bdaf2e1b4d9f46bb772bc630ace9c3a00c3294ab61315f1c0e817ba29d6";


    public static void main(String[] args) throws InterruptedException {
        BinanceFuturesApiClientFactory testnetFactory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient futureClient = testnetFactory.newRestClient();


        // Market Long Order
//        FuturesNewOrderResponse longResponse = futureClient.newOrder(FuturesNewOrder.MarketLong(SYMBOL, "1", false));
//        System.out.println(longResponse);

        // Market Short Order
//        FuturesNewOrderResponse shortResponse = futureClient.newOrder(FuturesNewOrder.MarketShort(SYMBOL, "0.5", false));
//        System.out.println(shortResponse);

        // Get open orders
//        List<Order> openOrders = futureClient.getOpenOrders(new OrderRequest(SYMBOL));
//        if (!openOrders.isEmpty()) {
//            openOrders.forEach(System.out::println);
//        } else {
//            System.out.println("You have not any open order");
//        }


        // Cancel Order
//        CancelOrderResponse cancelOrderResponse = futureClient.cancelOrder(new CancelOrderRequest(SYMBOL, longLimit.getOrderId()));
//        System.out.println(cancelOrderResponse);

        // Long Limit Order
//        FuturesNewOrderResponse longLimit = futureClient.newOrder(FuturesNewOrder.limitLong(SYMBOL, TimeInForce.GTC, "1", "58000", false));
//        System.out.println(longLimit);

        // Short Limit Order
//        FuturesNewOrderResponse shortLimit = futureClient.newOrder(FuturesNewOrder.limitShort(SYMBOL, TimeInForce.GTC, "1.5", "59050", false));
//        System.out.println(shortLimit);
    }

}
