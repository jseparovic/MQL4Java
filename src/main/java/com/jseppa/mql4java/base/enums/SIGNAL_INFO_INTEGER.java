package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SIGNAL_INFO_INTEGER
{

    SIGNAL_INFO_CONFIRMATIONS_DISABLED(1),
    SIGNAL_INFO_COPY_SLTP(2),
    SIGNAL_INFO_DEPOSIT_PERCENT(3),
    SIGNAL_INFO_ID(4),
    SIGNAL_INFO_SUBSCRIPTION_ENABLED(5),
    SIGNAL_INFO_TERMS_AGREE(6);

    int value;
    SIGNAL_INFO_INTEGER(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
