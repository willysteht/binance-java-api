package com.binance.api.client.factory;

import com.binance.api.client.BinanceEngineType;
import com.binance.api.client.config.*;
import com.binance.api.client.exception.BinanceIllegalException;

public abstract class BinanceAbstractFactory {

    public static BinanceFactory createFactory(String apiKey, String secretKey, BinanceEngineType engineType, Class<? extends BinanceApiConfig> apiConfigClass) {
        final String apiUrl = getApiUrl(apiConfigClass);
        final String websocketUrl = getWebsocketUrl(apiConfigClass);
        switch (engineType) {
            case SPOT:
                return BinanceSpotApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
            case FUTURES:
            case TESTNET:
                return BinanceFuturesApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
        }
        throw new IllegalArgumentException();
    }

    public static BinanceFactory createFactory(String apiKey, String secretKey, BinanceEngineType engineType) {
        switch (engineType) {
            case SPOT:
                return createSpotFactory(apiKey, secretKey);
            case FUTURES:
                return createFuturesFactory(apiKey, secretKey);
            case TESTNET:
                return createTestnetFactory(apiKey, secretKey);
        }
        throw new IllegalArgumentException();
    }

    public static BinanceSpotApiClientFactory createSpotFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(SpotApiConfig.class);
        final String websocketUrl = getWebsocketUrl(SpotApiConfig.class);
        return BinanceSpotApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    public static BinanceFuturesApiClientFactory createFuturesFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(FuturesApiConfig.class);
        final String websocketUrl = getWebsocketUrl(FuturesApiConfig.class);
        return BinanceFuturesApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    public static BinanceFuturesApiClientFactory createTestnetFactory(String apiKey, String secretKey) {
        final String apiUrl = getApiUrl(TestnetApiConfig.class);
        final String websocketUrl = getWebsocketUrl(TestnetApiConfig.class);
        return BinanceFuturesApiClientFactory.newInstance(apiKey, secretKey, apiUrl, websocketUrl);
    }

    public static BinanceSpotApiClientFactory createSpotFactory() {
        return createSpotFactory(null, null);
    }

    public static BinanceFuturesApiClientFactory createFuturesFactory() {
        return createFuturesFactory(null, null);
    }

    public static BinanceFuturesApiClientFactory createTestnetFactory() {
        return createTestnetFactory(null, null);
    }

    private static String getApiUrl(Class<? extends BinanceApiConfig> apiConfigClass) {
        return getApiConfig(apiConfigClass).apiUrl();
    }

    private static String getWebsocketUrl(Class<? extends BinanceApiConfig> apiConfigClass) {
        return getApiConfig(apiConfigClass).webSocketUrl();
    }

    private static ApiConfig getApiConfig(Class<? extends BinanceApiConfig> apiConfigClass) {
        if (apiConfigClass.isAnnotationPresent(ApiConfig.class)) {
            return apiConfigClass.getAnnotation(ApiConfig.class);
        } else {
            throw new BinanceIllegalException("Class should implemented BinanceApiConfig");
        }
    }

}
