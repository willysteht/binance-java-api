package com.binance.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniTickerEvent
{
/*
{
    "e": "24hrMiniTicker",  // Event type
    "E": 123456789,         // Event time
    "s": "BNBBTC",          // Symbol
    "c": "0.0025",          // Close price
    "o": "0.0010",          // Open price
    "h": "0.0025",          // High price
    "l": "0.0010",          // Low price
    "v": "10000",           // Total traded base asset volume
    "q": "18"               // Total traded quote asset volume
  }
 */
    @JsonProperty("e")
    private String eventType;

    @JsonProperty("E")
    private long eventTime;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("c")
    private double close;

    @JsonProperty("o")
    private double open;

    @JsonProperty("h")
    private double high;

    @JsonProperty("l")
    private double low;

    @JsonProperty("v")
    private double volume;

    @JsonProperty("q")
    private double quote;

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }

    public double getQuote() {
        return quote;
    }

    public double getVolume() {
        return volume;
    }

    public long getEventTime() {
        return eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public String getSymbol() {
        return symbol;
    }
}
