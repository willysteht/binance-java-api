package com.binance.api.client;

import com.binance.api.client.domain.account.Deposit;
import com.binance.api.client.domain.account.FuturesTransactionHistory;
import com.binance.api.client.domain.account.FuturesTransactionList;
import com.binance.api.client.domain.account.Withdraw;

import java.util.List;

import retrofit2.http.Query;

public interface WalletEndpoint {
    
    /**
     * Fetch account deposit history.
     *
     * @return deposit history, containing a list of deposits
     */
    List<Deposit> getDepositHistory(String asset, Integer status, Long startTime, Long endTime, Integer offset, Integer limit);
    List<Deposit> getDepositHistory(String asset);

    List<Deposit> getDepositHistory(String asset,long startTime);

    List<Deposit> getDepositHistory(long endTime);

    List<Deposit> getDepositHistory(long startTime,long endTime);
    List<Deposit> getDepositHistory(String asset,long startTime,long endTime);
    List<Deposit> getDepositHistory();

    /**
     * Fetch account withdraw history.
     *
     * @return withdraw history, containing a list of withdrawals
     */
    List<Withdraw> getWithdrawHistory(String asset);

    List<Withdraw> getWithdrawHistory(long startTime, long endTime);

    /**
     *                      Name 	    Type 	Mandatory 	Description
     * @param asset         asset 	    STRING 	YES
     * @param startTime     startTime 	LONG 	YES
     * @param endTime       endTime 	LONG 	NO
     * @param current       current 	LONG 	NO 	        Currently querying page. Start from 1. Default:1
     * @param size          size 	    LONG 	NO 	        Default:10 Max:100
     * @return
     */
    FuturesTransactionList getFutureTransactionHistory(String asset,
                                                       Long startTime,
                                                       Long endTime,
                                                       Long current,
                                                       Long size);

    FuturesTransactionList getFutureTransactionHistory(String asset,Long startTime);
    FuturesTransactionList getFutureTransactionHistory(String asset,Long startTime,Long endTime);

}
