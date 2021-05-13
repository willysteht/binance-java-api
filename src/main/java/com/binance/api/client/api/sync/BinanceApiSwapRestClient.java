package com.binance.api.client.api.sync;

import com.binance.api.client.domain.SwapRemoveType;
import com.binance.api.client.domain.swap.Liquidity;
import com.binance.api.client.domain.swap.LiquidityOperationRecord;
import com.binance.api.client.domain.swap.Pool;
import com.binance.api.client.domain.swap.SwapHistory;
import com.binance.api.client.domain.swap.SwapQuote;
import com.binance.api.client.domain.swap.SwapRecord;

import java.util.List;

public interface BinanceApiSwapRestClient {

    /**
     * Get metadata about all swap pools.
     *
     * @return
     */
    List<Pool> listAllSwapPools();

    /**
     * Get liquidity information and user share of a pool.
     *
     * @param poolId
     * @return
     */
    Liquidity getPoolLiquidityInfo(String poolId);

    /**
     * Add liquidity to a pool.
     *
     * @param poolId
     * @param asset
     * @param quantity
     * @return
     */
    LiquidityOperationRecord addLiquidity(String poolId,
                                          String asset,
                                          String quantity);

    /**
     * Remove liquidity from a pool, type include SINGLE and COMBINATION, asset is mandatory for single asset removal
     *
     * @param poolId
     * @param type
     * @param asset
     * @param shareAmount
     * @return
     */
    LiquidityOperationRecord removeLiquidity(String poolId, SwapRemoveType type, List<String> asset, String shareAmount);


    List<LiquidityOperationRecord> getPoolLiquidityOperationRecords(
            Long operationId,
            Long poolId,
            String operation,
            Long startTime,
            Long endTime,
            Long limit);


    /**
     * Request a quote for swap quote asset (selling asset) for base asset (buying asset), essentially price/exchange rates.
     *
     * @param quoteAsset
     * @param baseAsset
     * @param quoteQty
     * @return
     */
    SwapQuote requestQuote(String quoteAsset,
                           String baseAsset,
                           String quoteQty);

    /**
     * Swap quoteAsset for baseAsset
     *
     * @param quoteAsset
     * @param baseAsset
     * @param quoteQty
     * @return
     */
    SwapRecord swap(String quoteAsset,
                    String baseAsset,
                    String quoteQty);


    /*
    Name 	    Type 	Mandatory 	Description
    swapId 	    LONG 	NO
    startTime 	LONG 	NO
    endTime 	LONG 	NO
    status 	    INT 	NO 	0: pending for swap, 1: success, 2: failed
    quoteAsset 	STRING 	NO
    baseAsset 	STRING 	NO
    limit 	    LONG 	NO 	default 3, max 100
    recvWindow 	LONG 	NO
    timestamp 	LONG 	YES
     */
    List<SwapHistory> getSwapHistory(Long swapId, Long startTime, Long endTime, Integer status, String quoteAsset, String baseAsset, Long limit);
    List<SwapHistory> getSwapHistory();
}
