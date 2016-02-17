package com.jseppa.mql4java.base.enums;

/**
 * Created by Jason on 2/14/2016.
 */
public enum ALIGN_MODE
{
    ALIGN_LEFT(1),
    ALIGN_CENTER(2),
    ALIGN_RIGHT(3);

    int value;
    ALIGN_MODE(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
