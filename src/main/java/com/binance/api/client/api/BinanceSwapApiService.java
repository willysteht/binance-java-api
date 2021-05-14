package com.binance.api.client.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
    Call<List<Liquidity>> getPoolLiquidityInfo(@Query("poolId") @Nullable String poolId,
                                               @Query("recvWindow") @Nullable Long recvWindow,
                                               @Query("timestamp") @NonNull Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityAdd")
    Call<LiquidityOperationRecord> addLiquidity(@Query("poolId") @NonNull String poolId,
                                                @Query("asset") @NonNull String asset,
                                                @Query("quantity")@NonNull String quantity,
                                                @Query("recvWindow")@Nullable Long recvWindow,
                                                @Query("timestamp")@NonNull Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityRemove")
    Call<LiquidityOperationRecord> removeLiquidity(@Query("poolId") @NonNull String poolId,
                                                   @Query("type") @NonNull SwapRemoveType type,
                                                   @Query("asset") @NonNull List<String> asset,
                                                   @Query("shareAmount") @NonNull String shareAmount,
                                                   @Query("recvWindow") @Nullable Long recvWindow,
                                                   @Query("timestamp") @NonNull Long timestamp);


    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidityOps")
    Call<List<LiquidityOperationRecord>> getLiquidityOperationRecords(
            @Query("operationId")@Nullable Long operationId,
            @Query("poolId")@Nullable Long poolId,
            @Query("operation")@Nullable String operation,
            @Query("startTime")@Nullable Long startTime,
            @Query("endTime")@Nullable Long endTime,
            @Query("limit")@Nullable Long limit,
            @Query("recvWindow")@Nullable Long recvWindow,
            @Query("timestamp")@NonNull Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/quote")
    Call<SwapQuote> requestQuote(
            @Query("quoteAsset")@NonNull String quoteAsset,
            @Query("baseAsset")@NonNull String baseAsset,
            @Query("quoteQty")@NonNull String quoteQty,
            @Query("recvWindow")@Nullable Long recvWindow,
            @Query("timestamp")@NonNull Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/swap")
    Call<SwapRecord> swap(
            @Query("quoteAsset")@NonNull String quoteAsset,
            @Query("baseAsset")@NonNull String baseAsset,
            @Query("quoteQty")@NonNull String quoteQty,
            @Query("recvWindow")@Nullable Long recvWindow,
            @Query("timestamp")@NonNull Long timestamp);


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
