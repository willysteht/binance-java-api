package com.binance.api.client.api.sync;

import com.binance.api.client.domain.account.*;

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


    /**
     * Change leverage
     *
     * @param leverageRequest
     * @return LeverageResponse
     */
    LeverageResponse changeInitialLeverage(LeverageRequest leverageRequest);

    void changeMarginType(MarginTypeRequest marginTypeRequest);

}
