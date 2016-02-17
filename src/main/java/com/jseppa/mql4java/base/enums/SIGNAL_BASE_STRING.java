package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SIGNAL_BASE_STRING
{
    SIGNAL_BASE_AUTHOR_LOGIN(1),
    SIGNAL_BASE_BROKER(2),
    SIGNAL_BASE_BROKER_SERVER(3),
    SIGNAL_BASE_NAME(4),
    SIGNAL_BASE_CURRENCY(5);

    int value;
    SIGNAL_BASE_STRING(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
