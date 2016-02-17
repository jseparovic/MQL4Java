package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SELECTION_POOL
{

    MODE_TRADES(0),
    MODE_HISTORY(1);

    int value;
    SELECTION_POOL(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
