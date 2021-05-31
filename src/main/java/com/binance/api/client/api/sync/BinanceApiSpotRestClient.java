package com.binance.api.client.api.sync;




import com.binance.api.client.WalletEndpoint;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.AllOrderListRequest;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderListRequest;
import com.binance.api.client.domain.account.request.CancelOrderListResponse;
import com.binance.api.client.domain.account.request.OrderListStatusRequest;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapShotSpot;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshot;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshotFutures;
import com.binance.api.client.domain.account.snapshot.DailyAccountSnapshotMargin;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.TickerPrice;

import java.util.List;

import retrofit2.http.Query;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BinanceApiSpotRestClient extends BinanceApiGeneralRestClient {

    // Account endpoints

    /**
     * Send in a new order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    NewOrderResponse newOrder(NewOrder order);


    /**
     * Get Latest price for all symbols.
     */
    List<TickerPrice> getAllPrices();

    /**
     * Get best price/qty on the order book for all symbols.
     */
    List<BookTicker> getBookTickers();

    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param orderRequest order request parameters
     * @return a list of all account orders
     */
    List<Order> getAllOrders(AllOrdersRequest orderRequest);

    /**
     * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into the matching engine.
     *
     * @param order the new TEST order to submit.
     */
    void newOrderTest(NewOrder order);


    /**
     * Get current account information.
     */
    Account getAccount(Long recvWindow, Long timestamp);

    /**
     * Get current account information using default parameters.
     */
    Account getAccount();

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol symbol to get trades from
     * @param limit  default 500; max 1000
     * @param fromId TradeId to fetch from. Default gets most recent trades.
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp);

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol symbol to get trades from
     * @param limit  default 500; max 1000
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol, Integer limit);

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol symbol to get trades from
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol);

    List<Trade> getMyTrades(String symbol, Long fromId);
    List<Trade> getMyTrades(String symbol, Long fromId,int limit);

    /**
     * Submit a withdraw request.
     * <p>
     * Enable Withdrawals option has to be active in the API settings.
     *
     * @param asset      asset symbol to withdraw
     * @param address    address to withdraw to
     * @param amount     amount to withdraw
     * @param name       description/alias of the address
     * @param addressTag Secondary address identifier for coins like XRP,XMR etc.
     */
    WithdrawResult withdraw(String asset, String address, String amount, String name, String addressTag);

    /**
     * Fetch account deposit history.
     *
     * @return deposit history, containing a list of deposits
     */
    List<Deposit> getDepositHistory(String asset);

    /**
     * Fetch account withdraw history.
     *
     * @return withdraw history, containing a list of withdrawals
     */
    List<Withdraw> getWithdrawHistory(String asset);

    /**
     * Fetch sub-account transfer history.
     *
     * @return sub-account transfers
     */
    List<SubAccountTransfer> getSubAccountTransfers();

    /**
     * Fetch deposit address.
     *
     * @return deposit address for a given asset.
     */
    DepositAddress getDepositAddress(String asset);

    // User stream endpoints
    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    String startUserDataStream();

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void keepAliveUserDataStream(String listenKey);

    /**
     * Close out a new user data stream.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void closeUserDataStream(String listenKey);

    WalletEndpoint getWalletEndPoint();

    /**
     * Send in a new OCO;
     *
     * @param oco
     *            the OCO to submit
     * @return a response containing details about the newly placed OCO.
     */
    NewOCOResponse newOCO(NewOCO oco);

    /**
     * Cancel an entire Order List
     *
     * @return
     */
    CancelOrderListResponse cancelOrderList(CancelOrderListRequest cancelOrderListRequest);

    /**
     * Check an order list status
     *
     * @param orderListStatusRequest
     * @return an orderList
     */
    OrderList getOrderListStatus(OrderListStatusRequest orderListStatusRequest);

    /**
     * Get all list os orders
     *
     * @param allOrderListRequest
     * @return
     */
    List<OrderList> getAllOrderList(AllOrderListRequest allOrderListRequest);

    /**
     * Conver a list of assets to BNB
     * @param asset the list of assets to convert
     */
    DustTransferResponse dustTranfer(List<String> asset);

    DailyAccountSnapShotSpot getDailyAccountSnapShotSpot(
            @Query("startTime")  Long startTime,
            @Query("endTime")  Long endTime,
            @Query("limit")  Long limit
    );

    DailyAccountSnapshotMargin getDailyAccountSnapShotMargin(
            @Query("startTime")  Long startTime,
            @Query("endTime")  Long endTime,
            @Query("limit")  Long limit
    );

    DailyAccountSnapshotFutures getDailyAccountSnapShotFutures(
            @Query("startTime")  Long startTime,
            @Query("endTime")  Long endTime,
            @Query("limit")  Long limit
    );

}
