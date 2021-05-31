package com.binance.api.client.api;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderListResponse;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapShotSpot;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshot;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshotFutures;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshotMargin;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshotTypes;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.*;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
public interface BinanceApiService {

    // General endpoints

    @GET("/api/v1/ping")
    Call<Void> ping();

    @GET("/api/v1/time")
    Call<ServerTime> getServerTime();

    @GET("/api/v3/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();

    // Market data endpoints
    @GET("/api/v1/depth")
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/api/v1/trades")
    Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/api/v1/historicalTrades")
    Call<List<TradeHistoryItem>> getHistoricalTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId);

    @GET("/api/v1/aggTrades")
    Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId, @Query("limit") Integer limit,
                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    /*
        Name 	Type 	Mandatory 	Description
        symbol 	STRING 	YES
        interval 	ENUM 	YES
        startTime 	LONG 	NO
        endTime 	LONG 	NO
        limit 	INT 	NO 	Default 500; max 1000.
     */
    @GET("/api/v3/klines")
    Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol,
                                               @Query("interval") String interval,
                                               @Query("startTime") Long startTime,
                                               @Query("endTime") Long endTime,
                                               @Query("limit") Integer limit);

    @GET("/api/v1/ticker/24hr")
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    @GET("/api/v1/ticker/24hr")
    Call<List<TickerStatistics>> getAll24HrPriceStatistics();

    @GET("/api/v1/ticker/allPrices")
    Call<List<TickerPrice>> getLatestPrices();

    @GET("/api/v3/ticker/price")
    Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

    @GET("/api/v1/ticker/allBookTickers")
    Call<List<BookTicker>> getBookTickers();

    // Account endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                    @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                                    @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                    @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                    @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrderQuoteQty(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                            @Query("timeInForce") TimeInForce timeInForce, @Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
                                            @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                            @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/test")
    Call<Void> newOrderTest(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                            @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                            @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                            @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/order")
    Call<Order> getOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                               @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                               @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/order")
    Call<CancelOrderResponse> cancelOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                          @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/openOrders")
    Call<List<Order>> getOpenOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrders")
    Call<List<Order>> getAllOrders(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                   @Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/oco")
    Call<NewOCOResponse> newOCO(@Query("symbol") String symbol, @Query("listClientOrderId") String listClientOrderId, @Query("side") OrderSide side,
                                @Query("quantity") String quantity, @Query("limitClientOrderId") String limitClientOrderId, @Query("price") String price,
                                @Query("limitIcebergQty") String limitIcebergQty, @Query("stopClientOrderId")String stopClientOrderId, @Query("stopPrice") String stopPrice,
                                @Query("stopLimitPrice")String stopLimitPrice, @Query("stopIcebergQty") String stopIcebergQty, @Query("stopLimitTimeInForce") TimeInForce stopLimitTimeInForce,
                                @Query("newOrderRespType") NewOrderResponseType newOrderRespType, @Query("recvWindow") Long recvWindow, @Query("timestamp") long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/orderList")
    Call<CancelOrderListResponse> cancelOrderList(@Query("symbol") String symbol, @Query("orderListId") Long orderListId, @Query("listClientOrderId") String listClientOrderId,
                                                  @Query("newClientOrderId") String newClientOrderId, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/orderList")
    Call<OrderList> getOrderListStatus(@Query("orderListId") Long orderListId, @Query("origClientOrderId") String origClientOrderId,
                                       @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrderList")
    Call<List<OrderList>> getAllOrderList(@Query("fromId") Long fromId, @Query("startTime") Long startTime, @Query("endTime") Long endTime,
                                          @Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/account")
    Call<Account> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/wapi/v3/withdraw.html")
    Call<WithdrawResult> withdraw(@Query("asset") String asset, @Query("address") String address, @Query("amount") String amount, @Query("name") String name, @Query("addressTag") String addressTag,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


    /*
        Name 	Type 	Mandatory 	Description
        coin 	STRING 	NO
        status 	INT 	NO 	0(0:pending,6: credited but cannot withdraw, 1:success)
        startTime 	LONG 	NO 	Default: 90 days from current timestamp
        endTime 	LONG 	NO 	Default: present timestamp
        offset 	INT 	NO 	default:0
        limit 	INT 	NO
        recvWindow 	LONG 	NO
        timestamp 	LONG 	YES
     */
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/deposit/hisrec")
    Call<List<Deposit>> getDepositHistory(@Query("coin") String asset,
                                           @Query("status") Integer status,
                                           @Query("startTime") Long startTime,
                                           @Query("endTime") Long endTime,
                                           @Query("offset") Integer offset,
                                           @Query("limit") Integer limit,
                                           @Query("recvWindow") Long recvWindow,
                                           @Query("timestamp") Long timestamp);

    /*
        Name 	Type 	Mandatory 	Description
        coin 	STRING 	NO
        status 	INT 	NO 	0(0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected 4:Processing 5:Failure 6:Completed)
        offset 	INT 	NO
        limit 	INT 	NO
        startTime 	LONG 	NO 	Default: 90 days from current timestamp
        endTime 	LONG 	NO 	Default: present timestamp
        recvWindow 	LONG 	NO
        timestamp 	LONG 	YES
     */
    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/withdraw/history")
    Call<List<Withdraw>> getWithdrawHistory(@Query("coin") String asset,
                                             @Query("status") Integer status,
                                             @Query("startTime") Long startTime,
                                             @Query("endTime") Long endTime,
                                             @Query("offset") Integer offset,
                                             @Query("limit") Integer limit,
                                             @Query("recvWindow") Long recvWindow,
                                             @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/wapi/v3/depositAddress.html")
    Call<DepositAddress> getDepositAddress(@Query("asset") String asset, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/asset/dust")
    Call<DustTransferResponse> dustTransfer(@Query("asset") List<String> asset, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/sub-account/transfer/subUserHistory")
    Call<List<SubAccountTransfer>> getSubAccountTransfers(@Query("timestamp") Long timestamp);

    // User stream endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/api/v3/userDataStream")
    Call<ListenKey> startUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/api/v3/userDataStream")
    Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/api/v3/userDataStream")
    Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey);

    // Margin Account endpoints
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/transfer")
    Call<MarginTransaction> transfer(@Query("asset") String asset, @Query("amount") String amount, @Query("type") String type, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/loan")
    Call<MarginTransaction> borrow(@Query("asset") String asset, @Query("amount") String amount, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/loan")
    Call<LoanQueryResult> queryLoan(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/repay")
    Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/maxBorrowable")
    Call<MaxBorrowableQueryResult> queryMaxBorrowable(@Query("asset") String asset, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/repay")
    Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("startTime") Long starttime, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/repay")
    Call<MarginTransaction> repay(@Query("asset") String asset, @Query("amount") String amount, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/account")
    Call<MarginAccount> getMarginAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/openOrders")
    Call<List<Order>> getOpenMarginOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/order")
    Call<MarginNewOrderResponse> newMarginOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                                @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity,
                                                @Query("price") String price, @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                                @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                                @Query("sideEffectType") SideEffectType sideEffectType, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/margin/order")
    Call<CancelOrderResponse> cancelMarginOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                                @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                                @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/order")
    Call<Order> getMarginOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                     @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                                     @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/myTrades")
    Call<List<Trade>> getMyMarginTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                        @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream")
    Call<ListenKey> startMarginUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream")
    Call<Void> keepAliveMarginUserDataStream(@Query("listenKey") String listenKey);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/sapi/v1/userDataStream")
    Call<Void> closeAliveMarginUserDataStream(@Query("listenKey") String listenKey);
    // Binance Liquidity Swap Pool endpoints




    /*
    Name 	Type 	Mandatory 	Description
    asset 	STRING 	YES
    startTime 	LONG 	YES
    endTime 	LONG 	NO
    current 	LONG 	NO 	Currently querying page. Start from 1. Default:1
    size 	LONG 	NO 	Default:10 Max:100
    recvWindow 	LONG 	NO
    timestamp 	LONG 	YES
     */
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/futures/transfer")
    Call<FuturesTransactionList> getFutureAccountTransactionHistoryList(
            @Query("asset") String asset,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("current") Long current,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp
    );
    /**
     * Name 	Type 	Mandatory 	Description
     * type 	STRING 	YES 	"SPOT", "MARGIN", "FUTURES"
     * startTime 	LONG 	NO
     * endTime 	LONG 	NO
     * limit 	INT 	NO 	min 5, max 30, default 5
     * recvWindow 	LONG 	NO
     * timestamp 	LONG 	YES
     */

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/accountSnapshot")
    Call<DailyAccountSnapShotSpot> getDailyAccountSnapShotSpot(
            @Query("type")  String type,
            @Query("startTime")  Long startTime,
            @Query("endTime")  Long endTime,
            @Query("limit")  Long limit,
            @Query("recvWindow")  Long recvWindow,
            @Query("timestamp")  Long timestamp
    );

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/accountSnapshot")
    Call<DailyAccountSnapshotMargin> getDailyAccountSnapShotMargin(
            @Query("type")  String type,
            @Query("startTime")  Long startTime,
            @Query("endTime")  Long endTime,
            @Query("limit")  Long limit,
            @Query("recvWindow")  Long recvWindow,
            @Query("timestamp")  Long timestamp
    );

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/accountSnapshot")
    Call<DailyAccountSnapshotFutures> getDailyAccountSnapShotFutures(
            @Query("type")  String type,
            @Query("startTime")  Long startTime,
            @Query("endTime")  Long endTime,
            @Query("limit")  Long limit,
            @Query("recvWindow")  Long recvWindow,
            @Query("timestamp")  Long timestamp
    );
}
