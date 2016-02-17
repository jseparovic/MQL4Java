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

import com.jseppa.mql4java.base.enums.MQLCommand;
import com.jseppa.mql4java.base.exceptions.MQLException;
import com.jseppa.mql4java.base.exceptions.MQLExceptionHandler;
import com.jseppa.mql4java.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jseppa.mql4java.base.enums.CommonError.ERROR_NO_COMMAND;
import static com.jseppa.mql4java.base.enums.CommonError.ERROR_UNHANDLED;

public class MQLCommandManager
{
    public static Logger LOG = LoggerFactory.getLogger(MQLCommandManager.class);

    private Long ix;

    private HashMap<Integer, MQLCommandRequest> commandRequests;

    private static long UNLOCKED = -1;

    private Object synclock;
    private long commandlock;

    static char DELIMITER = (char) 29;

    private int counter;

    public MQLCommandManager(Long ix) throws Exception
    {
        LOG.debug(MessageFormat.format("Initializing MQLCommandManager: {0}", ix));
        this.commandRequests = new HashMap<>();
        this.ix = ix;
        counter = 0;
        synclock = new Object();
        commandlock = UNLOCKED;
    }

    public int execCommand(MQLCommand command, List<Object> parameters)
    {
        LOG.debug(MessageFormat.format("ExecCommand: {0}", command.toString()));
        int id;
        synchronized (synclock)
        {
            id = counter++;
            commandRequests.put(id, new MQLCommandRequest(id, command, parameters));
        }
        return id;
    }

    public Object getCommandResult(int id)
    {
        synchronized (synclock)
        {
            LOG.debug(MessageFormat.format("GetCommandResult: {0}", id));
            Object response = commandRequests.get(id).getResponse();
            commandRequests.remove(id);
            LOG.debug(MessageFormat.format("Response: {0}", response));
            return response;
        }
    }

    public static MQLCommandManager getInstance(Long ix) throws Exception
    {
        return DLLObjectWrapper.getInstance().getMQLCommandManager(ix);
    }

    public String getCommandParams(int id)
    {
        StringBuilder commandParams = new StringBuilder();

        String returnCommand = "";
        for (Object p : commandRequests.get(id).getParameters())
        {
            Object param = p;
            if (param instanceof Date)
            {
                // Convert DateTime to MT4 String
                param = DateUtil.toMT4TimeString((Date) p);
            }

            if (!commandParams.toString().equals(""))
            {
                commandParams.append(DELIMITER);
            }
            commandParams.append(param);
        }
        return commandParams.toString();
    }


    private void setCommandResponse(int id, Object response, int errorCode)
    {
        synchronized (synclock)
        {
            LOG.debug(MessageFormat.format("SetCommandResponse({0,number,#} {1} {2})", id, response, errorCode));
            commandRequests.get(id).setResponse(response);
            commandRequests.get(id).setError(errorCode);
            commandRequests.get(id).setCommandWaiting(false);
        }
    }

    public void throwExceptionIfErrorResponse(int id) throws MQLException
    {
        synchronized (synclock)
        {
            LOG.debug(MessageFormat.format("throwExceptionIfErrorResponse({0})", id, commandRequests.get(id).getError()));
            if (commandRequests.get(id).getError() > 0)
            {
                int error = commandRequests.get(id).getError();
                String command = commandRequests.get(id).getCommand().toString();
                String parameters = getCommandParams(id);
                commandRequests.remove(id);
                MQLExceptionHandler.getInstance().throwMQLException(error, MessageFormat.format("{0}({1})", command, parameters));
            }
        }
    }

    public boolean isCommandRunning(int id)
    {
        synchronized (synclock)
        {
            LOG.trace(MessageFormat.format("IsCommandRunning: {0}={1}", id, commandRequests.get(id).getCommandWaiting()));
            return commandRequests.get(id).getCommandWaiting();
        }
    }


    /**************************
     Exports
     **************************/

    public static int isCommandWaiting(long ix)
    {
        LOG.trace(MessageFormat.format("IsCommandWaiting: {0,number,#}", ix));
        try
        {
            synchronized (getInstance(ix).synclock)
            {
                for (Map.Entry<Integer, MQLCommandRequest> entry : getInstance(ix).commandRequests.entrySet())
                {
                    //LOG.debug(MessageFormat.format("IsCommandWaiting: commandRequest: {0}", pair.Value.ToString());
                    if (entry.getValue().getCommandWaiting())
                    {
                        //LOG.debug(MessageFormat.format("IsCommandWaiting: commandRequest: returning: {0}", pair.Key);
                        return entry.getKey();
                    }
                }
            }
            LOG.trace(MessageFormat.format("IsCommandWaiting: returning {0}", -1));
            return -1;
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return -1;
        }
    }


    public static int getCommandId(long ix, int id)
    {
        LOG.trace(MessageFormat.format("getCommandId: {0,number,#} (1)", ix, id));

        try
        {
            synchronized (getInstance(ix).synclock)
            {
                if (getInstance(ix).commandRequests.get(id).getCommandWaiting())
                {
                    return (int) getInstance(ix).commandRequests.get(id).getCommand().getValue();
                }
                else
                {
                    LOG.error(null, ERROR_NO_COMMAND);
                    return -1;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return -1;
        }
    }

    public static String getCommandName(long ix, int id)
    {
        LOG.trace(MessageFormat.format("getCommandName: {0,number,#} (1)", ix, id));

        try
        {
            synchronized (getInstance(ix).synclock)
            {
                if (getInstance(ix).commandRequests.get(id).getCommandWaiting())
                {
                    return getInstance(ix).commandRequests.get(id).getCommand().toString();
                }
                else
                {
                    LOG.error(null, ERROR_NO_COMMAND);
                    return ERROR_NO_COMMAND.toString();
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return ERROR_UNHANDLED.toString();
        }
    }

    public static String getCommandParams(long ix, int id)
    {
        LOG.trace(MessageFormat.format("getCommandParams: {0} (1)", ix, id));

        try
        {
            synchronized (getInstance(ix).synclock)
            {
                if (getInstance(ix).commandRequests.get(id).getCommandWaiting())
                {
                    return getInstance(ix).getCommandParams(id);
                }
                else
                {
                    LOG.error(ERROR_NO_COMMAND.toString());
                    return ERROR_NO_COMMAND.toString();
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return ERROR_UNHANDLED.toString();
        }
    }

    public static void setBoolCommandResponse(long ix, int id, boolean response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, response, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setDoubleCommandResponse(long ix, int id, double response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, response, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setIntCommandResponse(long ix, int id, int response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, response, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setStringCommandResponse(long ix, int id, String response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, response, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setVoidCommandResponse(long ix, int id, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, null, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setLongCommandResponse(long ix, int id, long response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, response, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setDateTimeCommandResponse(long ix, int id, long response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, new Date(response * 1000), error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static void setEnumCommandResponse(long ix, int id, int response, int error)
    {
        try
        {
            getInstance(ix).setCommandResponse(id, response, error);
        }
        catch (Exception e)
        {
            LOG.error(null, e);
        }
    }

    public static boolean commandLock(long ix)
    {
        try
        {
            synchronized (getInstance(ix).synclock)
            {
                if (getInstance(ix).commandlock == UNLOCKED)
                {
                    getInstance(ix).commandlock = ix;
                    LOG.trace("lock succeeded: " + ix);
                    return true;
                }
                else
                {
                    LOG.trace("lock failed: " + ix);
                    return false;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return false;
        }
    }

    public static boolean commandUnlock(long ix)
    {
        try
        {
            synchronized (getInstance(ix).synclock)
            {
                if (getInstance(ix).commandlock == ix)
                {
                    getInstance(ix).commandlock = UNLOCKED;
                    LOG.trace("unlock succeeded: " + ix);
                    return true;
                }
                else
                {
                    LOG.trace("unlock failed: " + ix);
                    return false;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(null, e);
            return false;
        }
    }
}
