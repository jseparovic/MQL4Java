package com.jseppa.mql4java.userdefined.strategy;

import com.jseppa.mql4java.base.enums.OBJECT_TYPE;
import com.jseppa.mql4java.base.enums.TIMEFRAME;
import com.jseppa.mql4java.base.mql.MQLBase;
import com.jseppa.mql4java.base.mql.MQLExpert;

import java.util.Date;

/**
 * Created by Jason on 2/14/2016.
 */
public class TestStrategy extends MQLBase
{
    boolean firstRun;

    public TestStrategy(Long ix)
    {
        super(ix);
        firstRun = true;
    }

    @Override
    public void onInit()
    {
        try
        {
            LOG.info("starting onInit in TestStrategy");
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    @Override
    public void onDeinit()
    {
        LOG.info("starting onDeinit in TestStrategy");
    }

    @Override
    public void onTick()
    {
        LOG.info("starting onTick in TestStrategy");

        if(firstRun)
        {
            try
            {
                Date now = new Date();
                Date yesterday = new Date(now.getTime() - 24 * 60 * 60 * 1000);
                LOG.info("starting onInit in TestStrategy");
                LOG.info("AccountBalance: " + AccountBalance());
                LOG.info("AccountCompany: " + AccountCompany());
                LOG.info("AccountEquity: " + AccountEquity());
                LOG.info("AccountFreeMargin: " + AccountFreeMargin());
                LOG.info("AccountName: " + AccountName());
                LOG.info("AccountNumber: " + AccountNumber());
                double price = 1.1130;
                ObjectCreate(ChartID(), "test", OBJECT_TYPE.OBJ_TREND, 0, yesterday, price, now, price);
                LOG.info("init() done: ");
            }
            catch (Exception e)
            {
                LOG.error(null, e);
            }
            finally
            {
                firstRun = false;
            }
        }
    }

    @Override
    public void onTimer()
    {
        LOG.info("starting onTimer in TestStrategy");
    }

}
