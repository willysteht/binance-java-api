package com.binance.api.client;

import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.domain.account.FuturesNewOrder;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;

import java.util.List;

public interface BinanceApiFuturesRestClient {
    /**
     * Get current margin account information using default parameters.
     */
    FuturesAccount getAccount();

    /**
     * Get all open orders on margin account for a symbol.
     *
     * @param orderRequest order request parameters
     */
    List<Order> getOpenOrders(OrderRequest orderRequest);

    /**
     * Send in a new margin order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    FuturesNewOrderResponse newOrder(FuturesNewOrder order);

    /**
     * Cancel an active margin order.
     *
     * @param cancelOrderRequest order status request parameters
     */
    CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);

    /**
     * Check margin order's status.
     *
     * @param orderStatusRequest order status request options/filters
     * @return an order
     */
    Order getOrderStatus(OrderStatusRequest orderStatusRequest);
}
