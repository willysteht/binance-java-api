package com.binance.api.client;

import android.text.TextUtils;

public class ToStringBuilder {

    private StringBuilder stringBuilder;

    public ToStringBuilder()
    {
        stringBuilder = new StringBuilder();
    }

    public<T> ToStringBuilder append(String in1, T in2)
    {
        stringBuilder.append(in1).append(" ").append(String.valueOf(in2)).append("\n");
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
