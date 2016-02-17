package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SIGNAL_INFO_DOUBLE
{

    SIGNAL_INFO_EQUITY_LIMIT(1),
    SIGNAL_INFO_SLIPPAGE(2),
    SIGNAL_INFO_VOLUME_PERCENT(3);

    int value;
    SIGNAL_INFO_DOUBLE(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
