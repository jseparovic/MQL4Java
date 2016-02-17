package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum MA_METHOD
{

    MODE_SMA(0), //	Simple averaging
    MODE_EMA(1), //	Exponential averaging
    MODE_SMMA(2), //	Smoothed averaging
    MODE_LWMA(3); //	Linear-weighted averaging
    
    int value;
    MA_METHOD(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
