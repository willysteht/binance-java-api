package com.binance.api.client.domain.event;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User data update event which can be of four types:
 * <p>
 * 1) outboundAccountInfo, whenever there is a change in the account (e.g. balance of an asset)
 * 2) outboundAccountPosition, the change in account balances caused by an event.
 * 3) executionReport, whenever there is a trade or an order
 * 4) balanceUpdate, the change in account balance (delta).
 * <p>
 * Deserialization could fail with UnsupportedEventException in case of unsupported eventType.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = UserDataUpdateEventDeserializer.class)
public class UserDataUpdateEvent {

    private UserDataUpdateEventType eventType;

    private long eventTime;

    private AccountUpdateEvent accountUpdateEvent;

    private BalanceUpdateEvent balanceUpdateEvent;

    private ExecutionReport executionReport;
    private OrderTradeUpdate orderTradeUpdate;

    public UserDataUpdateEventType getEventType() {
        return eventType;
    }

    public void setEventType(UserDataUpdateEventType eventType) {
        this.eventType = eventType;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public AccountUpdateEvent getAccountUpdateEvent() {
        return accountUpdateEvent;
    }

    public void setAccountUpdateEvent(AccountUpdateEvent accountUpdateEvent) {
        this.accountUpdateEvent = accountUpdateEvent;
    }

    public BalanceUpdateEvent getBalanceUpdateEvent() {
        return balanceUpdateEvent;
    }

    public void setBalanceUpdateEvent(BalanceUpdateEvent balanceUpdateEvent) {
        this.balanceUpdateEvent = balanceUpdateEvent;
    }

    public ExecutionReport getExecutionReport() {
        return executionReport;
    }

    public void setExecutionReport(ExecutionReport executionReport) {
        this.executionReport = executionReport;
    }

    public OrderTradeUpdate getOrderTradeUpdate() {
        return orderTradeUpdate;
    }

    public void setOrderTradeUpdate(OrderTradeUpdate orderTradeUpdate) {
        this.orderTradeUpdate = orderTradeUpdate;
    }

    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("eventType", eventType)
                .append("eventTime", eventTime);
        if (eventType == UserDataUpdateEventType.ACCOUNT_UPDATE) {
            sb.append("accountUpdateEvent", accountUpdateEvent);
        } else if (eventType == UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE) {
            sb.append("accountPositionUpdateEvent", accountUpdateEvent);
        } else if (eventType == UserDataUpdateEventType.BALANCE_UPDATE) {
            sb.append("balanceUpdateEvent", balanceUpdateEvent);
        } else if (eventType == UserDataUpdateEventType.ORDER_TRADE_UPDATE) {
            sb.append("orderTradeUpdate", orderTradeUpdate);
        } else {
            sb.append("executionReport", executionReport);
        }
        return sb.toString();
    }

    public enum UserDataUpdateEventType {
        ACCOUNT_POSITION_UPDATE("outboundAccountPosition"),
        BALANCE_UPDATE("balanceUpdate"),
        EXECUTION_REPORT("executionReport"),
        ACCOUNT_UPDATE("ACCOUNT_UPDATE"), //Binance futures & testnet
        ACCOUNT_CONFIG_UPDATE("ACCOUNT_CONFIG_UPDATE"), //Binance futures & testnet //TODO: Implement this type.
        ORDER_TRADE_UPDATE("ORDER_TRADE_UPDATE"); //Binance futures & testnet

        private final String eventTypeId;

        UserDataUpdateEventType(String eventTypeId) {
            this.eventTypeId = eventTypeId;
        }

        public String getEventTypeId() {
            return eventTypeId;
        }

        public static UserDataUpdateEventType fromEventTypeId(String eventTypeId) {
            UserDataUpdateEventType et = null;
            switch (eventTypeId) {
                case "outboundAccountPosition":
                    et = UserDataUpdateEventType.ACCOUNT_POSITION_UPDATE;
                    break;
                case "balanceUpdate":
                    et = UserDataUpdateEventType.BALANCE_UPDATE;
                    break;
                case "executionReport":
                    et = UserDataUpdateEventType.EXECUTION_REPORT;
                    break;
                case "ACCOUNT_UPDATE":
                    et = UserDataUpdateEventType.ACCOUNT_UPDATE;
                    break;
                case "ACCOUNT_CONFIG_UPDATE":
                    et = UserDataUpdateEventType.ACCOUNT_CONFIG_UPDATE;
                    break;
                case "ORDER_TRADE_UPDATE":
                    et = UserDataUpdateEventType.ORDER_TRADE_UPDATE;
                    break;
            }
            return et;
        }
    }
}
