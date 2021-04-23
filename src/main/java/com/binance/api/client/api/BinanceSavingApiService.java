package com.binance.api.client.api;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.FuturesTransactionList;
import com.binance.api.client.domain.saving.InterestHistory;
import com.binance.api.client.domain.saving.PurchaseRecord;
import com.binance.api.client.domain.saving.RedemptionRecord;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BinanceSavingApiService {

    /*
    Name 	Type 	Mandatory 	Description
    lendingType 	ENUM 	YES 	"DAILY" for flexible, "ACTIVITY" for activity, "CUSTOMIZED_FIXED" for fixed
    asset 	STRING 	NO
    startTime 	LONG 	NO
    endTime 	LONG 	NO
    current 	LONG 	NO 	Currently querying page. Start from 1. Default:1
    size 	LONG 	NO 	Default:10, Max:100
    recvWindow 	LONG 	NO 	The value cannot be greater than 60000
    timestamp 	LONG 	YES
     */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/lending/union/purchaseRecord")
    Call<List<PurchaseRecord>> getPurchaseRecord (
            @Query("lendingType") String lendingType,
            @Query("asset") String asset,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );

    /*
        Name 	Type 	Mandatory 	Description
        lendingType 	ENUM 	YES 	"DAILY" for flexible, "ACTIVITY" for activity, "CUSTOMIZED_FIXED" for fixed
        asset 	STRING 	NO
        startTime 	LONG 	NO
        endTime 	LONG 	NO
        current 	LONG 	NO 	Currently querying page. Start from 1. Default:1
        size 	LONG 	NO 	Default:10, Max:100
        recvWindow 	LONG 	NO 	The value cannot be greater than 60000
        timestamp 	LONG 	YES
     */

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/lending/union/redemptionRecord")
    Call<List<RedemptionRecord>> getRedemptionRecord (
            @Query("lendingType") String lendingType,
            @Query("asset") String asset,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );



    /*
    Name 	Type 	Mandatory 	Description
    lendingType 	ENUM 	YES 	"DAILY" for flexible, "ACTIVITY" for activity, "CUSTOMIZED_FIXED" for fixed
    asset 	STRING 	NO
    startTime 	LONG 	NO
    endTime 	LONG 	NO
    current 	LONG 	NO 	Currently querying page. Start from 1. Default:1
    size 	LONG 	NO 	Default:10, Max:100
    recvWindow 	LONG 	NO 	The value cannot be greater than 60000
    timestamp 	LONG 	YES
     */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/lending/union/interestHistory")
    Call<List<InterestHistory>> getInterestHistory (
            @Query("lendingType") String lendingType,
            @Query("asset") String asset,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );
}
