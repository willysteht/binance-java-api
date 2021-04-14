package com.binance.api.client;

import com.binance.api.client.domain.account.Deposit;
import com.binance.api.client.domain.account.Withdraw;

import java.util.List;

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
}
