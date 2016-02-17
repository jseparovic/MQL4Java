package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum APPLIED_PRICE
{

    PRICE_CLOSE(0), //	Close price
    PRICE_OPEN(1), // Open price
    PRICE_HIGH(2), // The maximum price for the period
    PRICE_LOW(3), // The minimum price for the period
    PRICE_MEDIAN(4), // Median price, (high + low)/2
    PRICE_TYPICAL(5), // Typical price, (high + low + close)/3
    PRICE_WEIGHTED(6); // Weighted close price, (high + low + close + close)/4

    int value;
    APPLIED_PRICE(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
