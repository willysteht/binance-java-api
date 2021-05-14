package com.binance.api.client.domain.swap;

public class SwapRecord {

    private String swapId;

    public String getSwapId() {
        return swapId;
    }

    public void setSwapId(String swapId) {
        this.swapId = swapId;
    }

    @Override
    public String toString() {
        return "SwapRecord{" +
                "swapId='" + swapId + '\'' +
                '}';
    }
}
