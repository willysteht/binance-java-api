package com.binance.api.client.factory;

import com.binance.api.client.*;
import com.binance.api.client.impl.*;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceSpotApiClientFactory implements BinanceFactory {

    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    private final String apiUrl;
    private final String websocketUrl;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceSpotApiClientFactory(String apiKey, String secret, String apiUrl, String websocketUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiUrl = apiUrl;
        this.websocketUrl = websocketUrl;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the binance api client factory
     */
    public static BinanceSpotApiClientFactory newInstance(String apiKey, String secret, String apiUrl, String websocketUrl) {
        return new BinanceSpotApiClientFactory(apiKey, secret, apiUrl, websocketUrl);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     * @see BinanceAbstractFactory
     * @deprecated please use BinanceAbstractFactory.createSpotFactory()
     */
    @Deprecated
    public static BinanceSpotApiClientFactory newInstance() {
        return new BinanceSpotApiClientFactory(null, null, null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BinanceApiRestClient newRestClient() {
        return new BinanceApiRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public BinanceApiAsyncRestClient newAsyncRestClient() {
        return new BinanceApiAsyncRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new asynchronous/non-blocking Margin REST client.
     */
    public BinanceApiAsyncMarginRestClient newAsyncMarginRestClient() {
        return new BinanceApiAsyncMarginRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new synchronous/blocking Margin REST client.
     */
    public BinanceApiMarginRestClient newMarginRestClient() {
        return new BinanceApiMarginRestClientImpl(apiKey, secret, apiUrl);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BinanceApiWebSocketClient newWebSocketClient() {
        return new BinanceApiWebSocketClientImpl(getSharedClient(), websocketUrl);
    }

    /**
     * Creates a new synchronous/blocking Swap REST client.
     */
    public BinanceApiSwapRestClient newSwapRestClient() {
        return new BinanceApiSwapRestClientImpl(apiKey, secret, apiUrl);
    }
}
