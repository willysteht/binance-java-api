package com.binance.api.client.domain.market;

import com.binance.api.client.exception.BinanceApiException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Contract type:
 *
 * PERPETUAL
 * CURRENT_MONTH
 * NEXT_MONTH
 * CURRENT_QUARTER 当季交割合约
 * NEXT_QUARTER 次季交割合约
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ContractType {
    PERPETUAL("PERPETUAL"),
    CURRENT_MONTH("CURRENT_MONTH"),
    NEXT_MONTH("NEXT_MONTH"),
    CURRENT_QUARTER("CURRENT_QUARTER"),
    NEXT_QUARTER("NEXT_QUARTER");

    private final String type;

    ContractType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ContractType getEnum(String intervalId) {
        switch (intervalId) {
            case "PERPETUAL":
                return ContractType.PERPETUAL;
            case "CURRENT_MONTH":
                return ContractType.CURRENT_MONTH;
            case "NEXT_MONTH":
                return ContractType.NEXT_MONTH;
            case "CURRENT_QUARTER":
                return ContractType.CURRENT_QUARTER;
            case "NEXT_QUARTER":
                return ContractType.NEXT_QUARTER;
            default:
                throw new BinanceApiException("Contract Type not defined");
        }
    }


}
