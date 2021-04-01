package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.domain.account.FuturesNewOrder;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiFuturesRestClientImpl implements BinanceApiFuturesRestClient {

    private final BinanceFuturesApiService binanceApiService;

    public BinanceApiFuturesRestClientImpl(String apiKey, String secret, String apiUrl) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceFuturesApiService.class, apiKey, secret, apiUrl);
    }

    @Override
    public FuturesAccount getAccount() {
        long timestamp = System.currentTimeMillis();
        return executeSync(binanceApiService.getAccount(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp));
    }

    @Override
    public List<Order> getOpenOrders(OrderRequest orderRequest) {
        return executeSync(binanceApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()));
    }

    @Override
    public FuturesNewOrderResponse newOrder(FuturesNewOrder order) {
        return executeSync(binanceApiService.newOrder(order.getSymbol(), order.getSide(), order.getPositionSide(),
                order.getType(), order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(),
                order.getStopPrice(), order.isClosePosition(), order.getActivationPrice(), order.getWorkingType(),
                order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(binanceApiService.cancelOrder(cancelOrderRequest.getSymbol(),
                cancelOrderRequest.getOrderId(), cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return executeSync(binanceApiService.getOrderStatus(orderStatusRequest.getSymbol(),
                orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }
}