/**
 Copyright 2016 Jason Separovic

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.jseppa.mql4java.base.mql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DLLObjectWrapper
{
    public static long DEFAULT_CHART_ID = 0L;

    public static Logger LOG = LoggerFactory.getLogger(DLLObjectWrapper.class);

    private static DLLObjectWrapper dllObjectWrapper;

    private static Object syncLock = new Object();

    private long restCommandLock;

    public static DLLObjectWrapper getInstance() throws Exception
    {
        synchronized (syncLock)
        {
            if (dllObjectWrapper == null)
            {
                dllObjectWrapper = new DLLObjectWrapper();
            }
        }
        return dllObjectWrapper;
    }

    private HashMap<Long, MQLCommandManager> mqlCommandManagers;
    private HashMap<Long, MQLExpert> mqlExperts;
    private HashMap<Long, ExecutorService> ExecutorServices;

    private int mqlExpertsIx;

    private Object mqlCommandManagersLock;
    private Object mqlExpertsLock;

    private DLLObjectWrapper() throws Exception
    {
        restCommandLock = 0;
        mqlExperts = new HashMap<Long, MQLExpert>();
        mqlCommandManagers = new HashMap<Long, MQLCommandManager>();
        ExecutorServices = new HashMap<Long, ExecutorService>();
        mqlExpertsLock = new Object();

        // create the default command manager for REST
        // Only need to use chart specific one for ChartObjects
        mqlCommandManagers.put(DEFAULT_CHART_ID, new MQLCommandManager(DEFAULT_CHART_ID));
    }

    public MQLCommandManager getMQLCommandManager(Long ix) throws Exception
    {
        if (mqlCommandManagers.containsKey(ix))
        {
            return mqlCommandManagers.get(ix);
        }
        else
        {
            throw new Exception("MQLCommandManager does not exist");
        }
    }

    public MQLExpert getMQLExpert(Long ix) throws Exception
    {
        if (mqlExperts.containsKey(ix))
        {
            return mqlExperts.get(ix);
        }
        else
        {
            throw new Exception("MQLExpert does not exist");
        }
    }

    public ExecutorService getExecutorService(Long ix) throws Exception
    {
        if (ExecutorServices.containsKey(ix))
        {
            return ExecutorServices.get(ix);
        }
        else
        {
            throw new Exception("ExecutorService does not exist");
        }
    }

    public void initExecutorService(Long ix)
    {
        synchronized (mqlExpertsLock)
        {
            try
            {
                ExecutorServices.put(ix, Executors.newSingleThreadExecutor());
            }
            catch (Exception e)
            {
                LOG.error(null, e);
            }
        }
    }

    public void initMQLExpert(Long ix, String className)
    {
        synchronized (mqlExpertsLock)
        {
            try
            {
                mqlCommandManagers.put(ix, new MQLCommandManager(ix));

                Class<?> clazz = Class.forName(className);
                Constructor<?> ctor = clazz.getConstructor(Long.class);
                Object object = ctor.newInstance(new Object[] { ix });
                mqlExperts.put(ix, (MQLExpert) object);
            }
            catch (Exception e)
            {
                LOG.error(null, e);
            }
        }
    }


    /**************************
        Exports
     **************************/

    public static boolean isCommandManagerReady(long ix) throws Exception
    {
        LOG.trace(MessageFormat.format("isCommandManagerReady: {0}", ix));

        if (getInstance().mqlCommandManagers.containsKey(ix))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
