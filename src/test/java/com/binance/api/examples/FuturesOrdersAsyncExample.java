package com.binance.api.examples;

import com.binance.api.client.BinanceApiAsyncFuturesRestClient;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.WorkingType;

import static com.binance.api.client.domain.account.FuturesNewOrder.limitLong;

/**
 * Examples on how to place orders, cancel them, and query account information.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class FuturesOrdersAsyncExample {

    private static final String SYMBOL = "LINKETH";

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiAsyncFuturesRestClient client = factory.newAsyncFuturesRestClient();


        // Placing a real LIMIT order
//        client.newOrder(limitLong(SYMBOL, TimeInForce.GTC, WorkingType.CONTRACT_PRICE, "13", "27", false), System.out::println);

        // Getting list of open orders
//        client.getOpenOrders(new OrderRequest(SYMBOL), System.out::println);

        // Get status of a particular order
//        client.getOrderStatus(new OrderStatusRequest(SYMBOL, 751698L), System.out::println);

        // Canceling an order
//        client.cancelOrder(new CancelOrderRequest(SYMBOL, 756762l), System.out::println);

    }

}
