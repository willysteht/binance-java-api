package com.binance.api.client.domain.account.snapshot;

import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.account.MarginAssetBalance;
import com.binance.api.client.domain.account.snapshot.data.FuturesData;
import com.binance.api.client.domain.account.snapshot.data.MarginData;
import com.binance.api.client.domain.account.snapshot.data.SpotData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;

public class SnapshotVosDeserializer extends JsonDeserializer<SnapshotVos> {
    @Override
    public SnapshotVos deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);
        JsonNode data = node.findValue("data");
        DailyAccountSnapshotTypes type = DailyAccountSnapshotTypes.valueOf(node.get(1).asText());
        long updateTime = node.findValue("updateTime").asLong();
        switch (type)
        {
            case SPOT:
                return getSpotSnapshot(data,updateTime);
            case MARGIN:
                return getMarginSnapshot(data,updateTime);
            case FUTURES:
                return getFuturesSnapshot(data,updateTime);
        }
        return null;
    }

    private SnapshotVos getSpotSnapshot(JsonNode data,long updateTime)
    {
        SnapshotVos<SpotData> spotDataSnapshotVos = new SnapshotVos<>();
        spotDataSnapshotVos.type = DailyAccountSnapshotTypes.SPOT;
        spotDataSnapshotVos.updateTime = updateTime;
        SpotData spotData = new SpotData();
        spotDataSnapshotVos.data = spotData;
        spotData.balances = new ArrayList<>();
        JsonNode bal = data.findValue("balances");
        for (JsonNode b : bal)
        {
            AssetBalance assetBalance = new AssetBalance();
            assetBalance.setAsset(b.findValue("asset").asText());
            assetBalance.setFree(b.findValue("free").asText());
            assetBalance.setLocked(b.findValue("locked").asText());
            spotData.balances.add(assetBalance);
        }
        spotData.totalAssetOfBtc = data.get(1).asText();
        return spotDataSnapshotVos;
    }

    private SnapshotVos getMarginSnapshot(JsonNode data, long updateTime)
    {
        SnapshotVos<MarginData> marginDataSnapshotVos = new SnapshotVos<>();
        marginDataSnapshotVos.type = DailyAccountSnapshotTypes.MARGIN;
        marginDataSnapshotVos.updateTime = updateTime;
        MarginData spotData = new MarginData();
        marginDataSnapshotVos.data = spotData;
        spotData.userAssets = new ArrayList<>();
        JsonNode bal = data.findValue("userAssets");
        for (JsonNode b : bal)
        {
            MarginAssetBalance assetBalance = new MarginAssetBalance();
            assetBalance.setAsset(b.findValue("asset").asText());
            assetBalance.setFree(b.findValue("free").asText());
            assetBalance.setLocked(b.findValue("locked").asText());
            assetBalance.setBorrowed(b.findValue("borrowed").asText());
            assetBalance.setInterest(b.findValue("interest").asText());
            assetBalance.setNetAsset(b.findValue("netAsset").asText());
            marginDataSnapshotVos.data.userAssets.add(assetBalance);
        }
        spotData.totalAssetOfBtc = data.get(1).asText();
        return marginDataSnapshotVos;
    }


    private SnapshotVos getFuturesSnapshot(JsonNode data, long updateTime)
    {
        SnapshotVos<FuturesData> futuresDataSnapshotVos = new SnapshotVos<>();
        futuresDataSnapshotVos.type = DailyAccountSnapshotTypes.FUTURES;
        futuresDataSnapshotVos.updateTime = updateTime;
        FuturesData spotData = new FuturesData();
        futuresDataSnapshotVos.data = spotData;
        spotData.assets = new ArrayList<>();
        JsonNode bal = data.findValue("assets");
        for (JsonNode b : bal)
        {
            FuturesSnapshotAsset assetBalance = new FuturesSnapshotAsset();
            assetBalance.asset =b.findValue("asset").asText();
            assetBalance.marginBalance = b.findValue("marginBalance").asText();
            assetBalance.walletBalance = b.findValue("walletBalance").asText();
            futuresDataSnapshotVos.data.assets.add(assetBalance);
        }

        JsonNode pos = data.findValue("position");
        for (JsonNode b : pos)
        {
            FuturesSnapshotPosition assetBalance = new FuturesSnapshotPosition();
            assetBalance.entryPrice =b.findValue("entryPrice").asText();
            assetBalance.markPrice = b.findValue("markPrice").asText();
            assetBalance.positionAmt = b.findValue("positionAmt").asText();
            assetBalance.symbol = b.findValue("symbol").asText();
            assetBalance.unRealizedProfit = b.findValue("unRealizedProfit").asText();
            futuresDataSnapshotVos.data.position.add(assetBalance);
        }
        return futuresDataSnapshotVos;
    }
}
