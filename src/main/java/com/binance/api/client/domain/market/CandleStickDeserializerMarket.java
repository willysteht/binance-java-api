package com.binance.api.client.domain.market;

import com.binance.api.client.domain.event.CandlestickEvent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CandleStickDeserializerMarket extends JsonDeserializer<Candlestick> {
    @Override
    public Candlestick deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);
        /**

         * [1575072000000,private Long openTime;
         * "7740.99000000",private String open;
         * "7810.00000000",private String high;
         * "7441.00000000",private String low;
         * "7541.89000000",private String close;
         * "46989.43361900", private String volume;
         * 1575158399999,private Long closeTime;
         * "358749026.36075541" private String quoteAssetVolume;
         * ,346506, private Long numberOfTrades;
         * "23743.61033700",private String takerBuyBaseAssetVolume;
         * "181318684.76790961",private String takerBuyQuoteAssetVolume;
         * "0"]
         */
        Candlestick candlestick = new Candlestick();
        candlestick.setOpenTime(node.get(0).asLong());
        candlestick.setOpen(node.get(1).asText());
        candlestick.setHigh(node.get(2).asText());
        candlestick.setLow(node.get(3).asText());
        candlestick.setClose(node.get(4).asText());
        candlestick.setVolume(node.get(5).asText());
        candlestick.setCloseTime(node.get(6).asLong());
        candlestick.setQuoteAssetVolume(node.get(7).asText());
        candlestick.setNumberOfTrades(node.get(8).asLong());
        candlestick.setTakerBuyBaseAssetVolume(node.get(9).asText());
        candlestick.setTakerBuyQuoteAssetVolume(node.get(10).asText());

        return candlestick;
    }
}
