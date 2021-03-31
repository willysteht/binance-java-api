package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.WorkingType;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;

import static com.binance.api.client.domain.account.FuturesNewOrder.limitLong;

/**
 * Examples on how to place orders, cancel them.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class FuturesOrdersExample {
    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiFuturesRestClient client = factory.newFuturesRestClient();

        FuturesNewOrderResponse futuresNewOrderResponse = client.newOrder(limitLong(SYMBOL, TimeInForce.GTC, WorkingType.CONTRACT_PRICE, "13", "27", false));
        long orderId = futuresNewOrderResponse.getOrderId();
        System.out.println("OrderID: " + orderId);

        CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest(SYMBOL, orderId));
        System.out.println("Order Status: " + cancelOrderResponse.getStatus());
    }

}
