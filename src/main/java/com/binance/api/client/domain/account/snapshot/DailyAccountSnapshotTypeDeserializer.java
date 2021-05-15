package com.binance.api.client.domain.account.snapshot;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class DailyAccountSnapshotTypeDeserializer extends JsonDeserializer<DailyAccountSnapshotTypes> {
    @Override
    public DailyAccountSnapshotTypes deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);
        return DailyAccountSnapshotTypes.valueOf(node.asText().toUpperCase());
    }
}
