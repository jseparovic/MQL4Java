/**
 * Copyright 2016 Jason Separovic
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jseppa.mql4java.base.mql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MQLExpert
{
    public static Logger LOG = LoggerFactory.getLogger(MQLExpert.class);

    Long timerInterval = 1000L;
    Date timer = new Date();
    ExecutorService executorService;
    private String typeName;
    private int baseStrategyIx;

    private boolean executingOnInit;
    private boolean executingOnTick;
    private boolean executingOnTimer;
    private boolean executingOnDeinit;

    final Boolean initialized[] = new Boolean[] {false};
    public Long ix;
    MQLCommandManager commandManager;

    public MQLExpert(Long ix)
    {
        this.ix = ix;
        this.executingOnInit = true;
        this.executingOnTick = false;
        this.executingOnTimer = false;
        this.executingOnDeinit = false;
    }

    public MQLCommandManager getCommandManager() throws Exception
    {
        return DLLObjectWrapper.getInstance().getMQLCommandManager(ix);
    }

    RateInfo[] rateInfo;

    int rateInfoSize;

    public void setTimerInterval(Long millis)
    {
        timerInterval = millis;
    }

    public static MQLExpert getInstance(Long ix) throws Exception
    {
        return DLLObjectWrapper.getInstance().getMQLExpert(ix);
    }

    private static ExecutorService getExecutorService(Long ix) throws Exception
    {
        return DLLObjectWrapper.getInstance().getExecutorService(ix);
    }

    int convIndex(int i)
    {
        return rateInfoSize - 1 - i;
    }

    public Date iTime(int i)
    {
        return new Date(rateInfo[convIndex(i)].time * 1000);
    }

    public double iOpen(int i)
    {
        return rateInfo[convIndex(i)].open;
    }

    public double iHigh(int i)
    {
        return rateInfo[convIndex(i)].high;
    }

    public double iLow(int i)
    {
        return rateInfo[convIndex(i)].low;
    }

    public double iVolume(int i)
    {
        return rateInfo[convIndex(i)].volume;
    }

    public double iClose(int i)
    {
        return rateInfo[convIndex(i)].close;
    }


    /**************************
     Exports
     **************************/

    public static void initRates(Long ix, RateInfo[] arr, int arr_size)
    {
        LOG.info("Initializing Rates: " + ix);
        boolean initialized = false;
        while (!initialized)
        {
            try
            {
                getInstance(ix).rateInfo = arr;
                getInstance(ix).rateInfoSize = arr_size;
                initialized = true;
            }
            catch (Exception e)
            {
                LOG.error(null, e);
            }
        }
    }

    public static void setRatesSize(long ix, int arr_size)
    {
        try
        {
            getInstance(ix).rateInfoSize = arr_size;
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }

    }

    public static boolean isExecutingOnTick(long ix)
    {
        try
        {
            return getInstance(ix).executingOnTick;
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return true;
        }
    }


    public static boolean isExecutingOnInit(long ix)
    {
        try
        {
            return getInstance(ix).executingOnInit;
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return true;
        }
    }

    public static boolean isExecutingOnTimer(long ix)
    {
        try
        {
            return getInstance(ix).executingOnTimer;
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return true;
        }
    }

    public static boolean isExecutingOnDeinit(long ix)
    {
        try
        {
            return getInstance(ix).executingOnDeinit;
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return true;
        }
    }

    public static void execOnInit(long ix, String type)
    {
        try
        {
            LOG.debug(MessageFormat.format("execOnInit: {0}, {1}", ix, type));
            DLLObjectWrapper.getInstance().initExecutorService(ix);
            final long index = ix;
            Callable<Boolean> task = () -> {
                try
                {
                    DLLObjectWrapper.getInstance().initMQLExpert(index, type);
                    getInstance(index).onInit();
                    getInstance(index).initialized[0] = true;
                    return true;
                }
                catch (Exception e)
                {
                    LOG.error(null, e);
                    throw e;
                }
                finally
                {
                    try
                    {
                        getInstance(index).executingOnInit = false;
                    }
                    catch (Exception e)
                    {
                        LOG.error(null, e);
                        throw e;
                    }
                }
            };

            Future<Boolean> future = getExecutorService(ix).submit(task);
            //Boolean result = future.get();
            //if(result) LOG.debug("execOnInit returned OK");

        }
        catch (Exception e)
        {
            LOG.error("execOnInit returned ERROR", e);
        }
    }


    public static void execOnDeinit(long ix)
    {
        try
        {
            LOG.debug(MessageFormat.format("execOnDeinit: {0}", ix));
            getInstance(ix).executingOnDeinit = true;
            final long index = ix;
            Callable<Boolean> task = () -> {
                try
                {
                    getInstance(index).onDeinit();
                    return true;
                }
                catch (Exception e)
                {
                    LOG.error(null, e);
                    throw e;
                }
                finally
                {
                    try
                    {
                        getInstance(index).executingOnDeinit = false;
                    }
                    catch (Exception e)
                    {
                        LOG.error(null, e);
                        throw e;
                    }
                }
            };

            Future<Boolean> future = getExecutorService(ix).submit(task);
            //Boolean result = future.get();
            //if(result) LOG.debug("execOnDeinit returned OK");

        }
        catch (Exception e)
        {
            LOG.error("execOnDeinit returned ERROR", e);
        }
    }


    public static void execOnTick(long ix)
    {

        try
        {
            if(!getInstance(ix).initialized[0]) return;

            LOG.debug(MessageFormat.format("execOnTick: {0}", ix));
            getInstance(ix).executingOnTick = true;
            final long index = ix;
            Callable<Boolean> task = () -> {
                try
                {
                    getInstance(index).onTick();
                    return true;
                }
                catch (Exception e)
                {
                    LOG.error(null, e);
                    throw e;
                }
                finally
                {
                    try
                    {
                        getInstance(index).executingOnTick = false;
                    }
                    catch (Exception e)
                    {
                        LOG.error(null, e);
                        throw e;
                    }
                }
            };

            Future<Boolean> future = getExecutorService(ix).submit(task);
            //Boolean result = future.get();
            //if(result) LOG.debug("execOnTick returned OK");

        }
        catch (Exception e)
        {
            LOG.error("execOnTick returned ERROR", e);
        }
    }


    public static void execOnTimer(long ix)
    {
        try
        {
            if(!getInstance(ix).initialized[0]) return;

            LOG.debug(MessageFormat.format("execOnTimer: {0}", ix));
            final long index = ix;

            Date now = new Date();
            if (now.getTime() >= getInstance(ix).timer.getTime() + getInstance(ix).timerInterval) // execute every timeout millis
            {
                getInstance(ix).executingOnTimer = true;
                LOG.debug("execOnTimer executing");

                getInstance(ix).timer = now;
                Callable<Boolean> task = () -> {
                    try
                    {
                        getInstance(index).onTimer();
                        return true;
                    }
                    catch (Exception e)
                    {
                        LOG.error(null, e);
                        throw e;
                    }
                    finally
                    {
                        try
                        {
                            getInstance(index).executingOnTimer = false;
                        }
                        catch (Exception e)
                        {
                            LOG.error(null, e);
                            throw e;
                        }
                    }
                };

                Future<Boolean> future = getExecutorService(ix).submit(task);
                //Boolean result = future.get();
                //if (result) LOG.debug("execOnTimer returned OK");
            }
            else
            {
                LOG.debug("execOnTimer not executing yet");
            }
        }
        catch (Exception e)
        {
            LOG.error("execOnTimer returned ERROR", e);
        }
    }


    public void onInit()
    {
    }

    public void onDeinit()
    {
    }

    public void onTick()
    {
    }

    public void onTimer()
    {
    }
}
