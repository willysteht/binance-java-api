package com.binance.api.client.api;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.SwapRemoveType;
import com.binance.api.client.domain.swap.Liquidity;
import com.binance.api.client.domain.swap.LiquidityOperationRecord;
import com.binance.api.client.domain.swap.Pool;
import com.binance.api.client.domain.swap.SwapHistory;
import com.binance.api.client.domain.swap.SwapQuote;
import com.binance.api.client.domain.swap.SwapRecord;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BinanceSwapApiService {

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/bswap/pools")
    Call<List<Pool>> listAllSwapPools();

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidity")
    Call<List<Liquidity>> getPoolLiquidityInfo(@Query("poolId")  String poolId,
                                               @Query("recvWindow")  Long recvWindow,
                                               @Query("timestamp")  Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityAdd")
    Call<LiquidityOperationRecord> addLiquidity(@Query("poolId")  String poolId,
                                                @Query("asset")  String asset,
                                                @Query("quantity") String quantity,
                                                @Query("recvWindow") Long recvWindow,
                                                @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityRemove")
    Call<LiquidityOperationRecord> removeLiquidity(@Query("poolId")  String poolId,
                                                   @Query("type")  SwapRemoveType type,
                                                   @Query("asset")  List<String> asset,
                                                   @Query("shareAmount")  String shareAmount,
                                                   @Query("recvWindow")  Long recvWindow,
                                                   @Query("timestamp")  Long timestamp);


    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidityOps")
    Call<List<LiquidityOperationRecord>> getLiquidityOperationRecords(
            @Query("operationId") Long operationId,
            @Query("poolId") Long poolId,
            @Query("operation") String operation,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Long limit,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/quote")
    Call<SwapQuote> requestQuote(
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("quoteQty") String quoteQty,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/swap")
    Call<SwapRecord> swap(
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("quoteQty") String quoteQty,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);


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
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/swap")
    Call<List<SwapHistory>> getSwapHistory(
            @Query("swapId") Long swapId,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("status") Integer status,
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("limit") Long limit,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);
}
