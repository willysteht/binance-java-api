package com.binance.api.client.factory;

import com.binance.api.client.api.async.BinanceApiSavingAsyncRestClient;
import com.binance.api.client.api.async.BinanceApiSwapAsyncRestClient;
import com.binance.api.client.api.sync.BinanceApiSavingRestClient;
import com.binance.api.client.api.sync.BinanceApiSwapRestClient;
import com.binance.api.client.impl.async.BinanceApiSavingAsyncRestClientImpl;
import com.binance.api.client.impl.async.BinanceApiSwapAsyncRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiSavingRestClientImpl;
import com.binance.api.client.impl.sync.BinanceApiSwapRestClientImpl;

public class BinanceSavingApiClientFactory implements BinanceFactory<BinanceApiSavingRestClient, BinanceApiSavingAsyncRestClient> {
    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    private final String apiUrl;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceSavingApiClientFactory(String apiKey, String secret, String apiUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiUrl = apiUrl;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the binance api client factory
     */
    public static BinanceSavingApiClientFactory newInstance(String apiKey, String secret, String apiUrl) {
        return new BinanceSavingApiClientFactory(apiKey, secret, apiUrl);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     * @see BinanceAbstractFactory
     */
    public static BinanceSavingApiClientFactory newInstance() {
        return new BinanceSavingApiClientFactory(null, null, null);
    }

    /**
     * Creates a new synchronous/blocking Swap REST client.
     */
    public BinanceApiSavingRestClient newRestClient() {
        return new BinanceApiSavingRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BinanceApiSavingAsyncRestClient newAsyncRestClient() {
        return new BinanceApiSavingAsyncRestClientImpl(apiKey, secret, apiUrl);
    }
}
