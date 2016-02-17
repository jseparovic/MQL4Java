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

import com.jseppa.mql4java.base.enums.MQLCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;

public class MQLCommandRequest
{
    public Logger LOG = LoggerFactory.getLogger(getClass());

    private int id;
    private MQLCommand command;
    private List<Object> parameters;
    private Boolean commandWaiting;
    private Object response;
    private int error;

    public MQLCommandRequest(int id, MQLCommand command, List<Object> parameters)
    {
        this.id = id;
        this.command = command;
        this.parameters = parameters;
        this.error = 0;
        this.commandWaiting = true;
        LOG.debug(MessageFormat.format("MQLCommandRequest: {0}", this));
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public MQLCommand getCommand()
    {
        return command;
    }

    public void setCommand(MQLCommand command)
    {
        this.command = command;
    }

    public List<Object> getParameters()
    {
        return parameters;
    }

    public void setParameters(List<Object> parameters)
    {
        this.parameters = parameters;
    }

    public Boolean getCommandWaiting()
    {
        return commandWaiting;
    }

    public void setCommandWaiting(Boolean commandWaiting)
    {
        this.commandWaiting = commandWaiting;
    }

    public Object getResponse()
    {
        return response;
    }

    public void setResponse(Object response)
    {
        this.response = response;
    }

    public int getError()
    {
        return error;
    }

    public void setError(int error)
    {
        this.error = error;
    }

    @Override
    public String toString()
    {
        return "MQLCommandRequest{" +
                "id=" + id +
                ", command=" + command +
                ", parameters=" + parameters +
                ", commandWaiting=" + commandWaiting +
                ", response=" + response +
                ", error=" + error +
                '}';
    }
}
