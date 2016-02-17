package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum TRADE_OPERATION
{

    OP_BUY(0), // Buy operation
    OP_SELL(1), // Sell operation
    OP_BUYLIMIT(2),  //Buy limit pending order
    OP_SELLLIMIT(3), // Sell limit pending order
    OP_BUYSTOP(4), // Buy stop pending order
    OP_SELLSTOP(5); // Sell stop pending order

    int value;
    TRADE_OPERATION(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
