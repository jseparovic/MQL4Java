package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SIGNAL_INFO_STRING
{
    SIGNAL_INFO_NAME(1);

    int value;
    SIGNAL_INFO_STRING(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
