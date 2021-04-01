package com.binance.api.client.factory;

public interface BinanceFactory {

    <T> T newAsyncRestClient();

    <T> T newRestClient();

    <T> T newWebSocketClient();
}
