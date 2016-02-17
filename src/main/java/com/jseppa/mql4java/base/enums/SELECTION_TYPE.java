package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/15/2016.
 */
public enum SELECTION_TYPE
{
    SELECT_BY_POS(0),
    SELECT_BY_TICKET(1);

    int value;
    SELECTION_TYPE(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
