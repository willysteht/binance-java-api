package com.binance.api.examples.testnet;

import com.binance.api.client.api.sync.BinanceApiFuturesRestClient;
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

        FuturesNewOrderResponse stopLimitShort = futureClient.newOrder(FuturesNewOrder.stopLimitShort(SYMBOL, "1", "58814", false));
        System.out.println(stopLimitShort);

    }

}
