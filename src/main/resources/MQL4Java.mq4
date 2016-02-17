/*
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

#include <mc_helpers.mqh>
#include <mc_funcs.mqh>
#include <mc_returns.mqh>

#import "mql4j-java.dll"
bool     javaStart();
bool     javaStatus();
string   javaCall(string className, string methodName, string arg);
void     execOnInit(long, string);
int      initRates(long, MqlRates&[], int);
void     setRatesSize(long, int);
void     execOnDeinit(long);
void     execOnTick(long);
void     execOnTimer(long);
bool     isExecutingOnInit(long);
bool     isExecutingOnTick(long);
bool     isExecutingOnTimer(long);
bool     isExecutingOnDeinit(long);
bool     isCommandManagerReady(long);
int      isCommandWaiting(long);
int      getCommandId(long, int);
string   getCommandName(long, int);
string   getCommandParams(long, int);
void     setBoolCommandResponse(long, int, bool, int);
void     setDoubleCommandResponse(long, int, double, int);
void     setIntCommandResponse(long, int, int, int);
void     setStringCommandResponse(long, int, string, int);
void     setVoidCommandResponse(long, int, int);
void     setLongCommandResponse(long, int, long, int);
void     setDateTimeCommandResponse(long, int, datetime, int);
void     setEnumCommandResponse(long, int, int, int);
bool     commandLock(long);
bool     commandUnlock(long);
#import


int ratesSize;
MqlRates rates[];
long chartID;

input string FullTypeName = "com.jseppa.mql4java.userdefined.strategy.TestStrategy";

int INFO = 3;
int DEBUG = 4;
int TRACE = 5;

int LOGLEVEL = INFO;

int PAUSE_AFTER_INIT = 0;

char DELIM = 29;

int DEFAULT_CHART_ID = 0;

int EVENT_TIMER_MILLIS = 1;

void maintainRates(long ix)
{
   // update rates array size
   if(ratesSize != ArraySize(rates))
   {
      setRatesSize(ix, ArraySize(rates));
   }
}

void info(string m1, string m2 = "", string m3 = "", string m4 = "", string m5 = "", string m6 = "", string m7 = "", string m8 = "", string m9 = "", string m10 = "")
{
   if(LOGLEVEL >= INFO)
   {
      Print(StringTrimRight(StringFormat("[INFO] %s %s %s %s %s %s %s %s %s %s", m1,m2,m3,m4,m5,m6,m7,m8,m9,m10)));
   }
}

void debug(string m1, string m2 = "", string m3 = "", string m4 = "", string m5 = "", string m6 = "", string m7 = "", string m8 = "", string m9 = "", string m10 = "")
{
   if(LOGLEVEL >= DEBUG)
   {
      Print(StringTrimRight(StringFormat("[DEBUG] %s %s %s %s %s %s %s %s %s %s", m1,m2,m3,m4,m5,m6,m7,m8,m9,m10)));
   }
}

void trace(string m1, string m2 = "", string m3 = "", string m4 = "", string m5 = "", string m6 = "", string m7 = "", string m8 = "", string m9 = "", string m10 = "")
{
   if(LOGLEVEL >= TRACE)
   {
      Print(StringTrimRight(StringFormat("[TRACE] %s %s %s %s %s %s %s %s %s %s", m1,m2,m3,m4,m5,m6,m7,m8,m9,m10)));
   }
}

bool executeCommands(long ix)
{
   trace("isCommandWaiting(): " + isCommandWaiting(ix));
   int requestId;
   while((requestId = isCommandWaiting(ix)) != -1)
   {
      debug("Executing Commands");
      if(commandLock(ix))
      {
         debug("Locked");
         int id = getCommandId(ix, requestId);
         string name = "";
         string params = "";
         name = getCommandName(ix, requestId);
         params = getCommandParams(ix, requestId);

         debug("name: " +  name);
         debug("params: " +  params);

         // Parse the command
         string paramArray[];
         StringSplit(params, DELIM, paramArray);

         int returnType = getCommandReturnType(id);

         // reset last error
         ResetLastError();

         int error;
         if(returnType == RETURN_TYPE_BOOL)
         {
            bool boolresult = executeBoolCommand(id, paramArray);
            error = GetLastError();
            trace ("command: " + name + ", params" + params + ", result: " + boolresult + ", error: " + error);
            setBoolCommandResponse(ix, requestId, boolresult, error);
         }
         else if(returnType == RETURN_TYPE_DOUBLE)
         {
            double doubleresult = executeDoubleCommand(id, paramArray);
            error = GetLastError();
            trace ("command: " + name + ", params" + params + ", result: " + doubleresult + ", error: " + error);
            setDoubleCommandResponse(ix, requestId, doubleresult, error);
         }
         else if(returnType == RETURN_TYPE_INT)
         {
            int intresult = executeIntCommand(id, paramArray);
            error = GetLastError();
            trace ("command: " + name + ", params" + params + ", result: " + intresult + ", error: " + error);
            setIntCommandResponse(ix, requestId, intresult, error);
         }
         else if(returnType == RETURN_TYPE_STRING)
         {
            string stringresult = executeStringCommand(id, paramArray);
            error = GetLastError();
            trace ("command: " + name + ", params" + params + ", result: " + stringresult + ", error: " + error);
            setStringCommandResponse(ix, requestId, stringresult, error);
         }
         else if(returnType == RETURN_TYPE_VOID)
         {
            executeVoidCommand(id, paramArray);
            trace ("command: " + name + ", params" + params + ", error: " + error);
            setVoidCommandResponse(ix, requestId, GetLastError());
         }
         else if(returnType == RETURN_TYPE_LONG)
         {
            long longresult = executeLongCommand(id, paramArray);
            error = GetLastError();
            trace ("command: " + name + ", params" + params + ", result: " + longresult + ", error: " + error);
            setLongCommandResponse(ix, requestId, longresult, error);
         }
         else if(returnType == RETURN_TYPE_DATETIME)
         {
            datetime datetimeresult = executeDateTimeCommand(id, paramArray);
            error = GetLastError();
            trace ("command: " + name + ", params" + params + ", result: " + datetimeresult + ", error: " + error);
            setDateTimeCommandResponse(ix, requestId, datetimeresult, error);
         }

         debug("Unlocking");
         commandUnlock(ix);
         debug("Unlocked");
      }

   }
   return false;
}



int OnInit()
{
   if(!javaStatus())
     {
      if(javaStart())
        {
         Print("Mql4j service started");
        }
      else
        {
         MessageBox("Mql4j service start failed. See mql4j.log / mql4j.java.log for details","MQL4J Java Example",MB_OK|MB_ICONERROR);
         return;
        }
     }


   EventSetMillisecondTimer(EVENT_TIMER_MILLIS);

   // Copy the rates array and pass it to the library
   ArrayCopyRates(rates, NULL, 0);
   ratesSize = ArraySize(rates);
   chartID = ChartID();
   info("OnInit() ExecOnInit: ", chartID, ", ", FullTypeName);
   execOnInit(chartID, FullTypeName);

   Sleep(PAUSE_AFTER_INIT * 1000); //time to attach the debugger

   info("OnInit() Waiting for Command Manager");
   while(!isCommandManagerReady(chartID))
   {

   }

   info("OnInit() executeCommands on Init");
   while(isExecutingOnInit(chartID))
   {
      trace("OnInit() IsExecutingOnInit(chartID)");
      executeCommands(chartID);
   }

   // execute default REST commands
   info("OnInit() executeCommands REST");
   executeCommands(DEFAULT_CHART_ID);

   info("OnInit() Initializing rates");
   initRates(chartID, rates, ratesSize);

   info("OnInit() OnInit complete");
   return(INIT_SUCCEEDED);
}

void OnDeinit(const int reason)
{
   // Call the DLL onDeinit
   execOnDeinit(chartID);

   // execute commands that are waiting
   while(isExecutingOnDeinit(chartID))
   {
      executeCommands(chartID);
   }

   // execute default REST commands
   executeCommands(DEFAULT_CHART_ID);
}


void OnTick()
{
   // Call the DLL onTick
   execOnTick(chartID);

   // execute commands that are waiting
   while(isExecutingOnTick(chartID))
   {
      executeCommands(chartID);
   }

   // execute default REST commands
   executeCommands(DEFAULT_CHART_ID);

   // Keep the rates array size up to date
   maintainRates(chartID);
}


void OnTimer()
{
   trace ("execOnTimer", chartID );
   execOnTimer(chartID);

   // execute commands that are waiting
   trace ("isExecutingOnTimer", chartID );
   while(isExecutingOnTimer(chartID))
   {
      executeCommands(chartID);
   }

   // execute default REST commands
   executeCommands(DEFAULT_CHART_ID);
}
