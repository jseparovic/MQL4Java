package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SIGNAL_BASE_DOUBLE
{
    SIGNAL_BASE_BALANCE(1),
    SIGNAL_BASE_EQUITY(2),
    SIGNAL_BASE_GAIN(3),
    SIGNAL_BASE_MAX_DRAWDOWN(4),
    SIGNAL_BASE_PRICE(5),
    SIGNAL_BASE_ROI(6);

    int value;
    SIGNAL_BASE_DOUBLE(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
