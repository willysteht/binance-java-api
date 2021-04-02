package com.binance.api.client.api.sync;

import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.domain.account.FuturesNewOrder;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;

public interface BinanceApiFuturesRestClient extends BinanceApiGeneralRestClient {

    /**
     * Get current margin account information using default parameters.
     */
    FuturesAccount getAccount();

    /**
     * Send in a new margin order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    FuturesNewOrderResponse newOrder(FuturesNewOrder order);
}
