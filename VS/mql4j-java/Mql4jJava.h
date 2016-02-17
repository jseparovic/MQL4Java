/**
 *	Mql4j
 *
 *	Mql4j is a free and open source library written to create projects and code
 *	in java programming language in MetaQuotes MetaTrader 4 trading solution.
 *
 *	Copyright 2015 Michael Schmidt (michael . schmidt at mql4j . com)
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

 /**
 * Modification Notice From: Jason Separovic
 * For a detailed descirption of changes please view Pull Request: https://github.com/jseparovic/mql4j/pull/1/files
 */


#pragma once
#ifdef MQL4J_EXPORTS
	#define MQL4J_API __declspec(dllexport)
#else
	#define MQL4J_API __declspec(dllimport)
#endif
#include "JavaJvm.h"
#include "JavaExecutor.h"
#include "JavaMethodDesc.h"
#include "..\mql4j-common\Mql4jString.h"
#include "..\mql4j-common\Mql4jCommon.h"

#define EXEC_ON_INIT_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define EXEC_ON_INIT_METHOD "execOnInit"
#define EXEC_ON_INIT_SIGNATURE "(JLjava/lang/String;)V"

//int initRates(long, RateInfo[], int) { return 0; }
#define INIT_RATES_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define INIT_RATES_METHOD "initRates"
#define INIT_RATES_SIGNATURE "(JLjava/lang/String;)V"

//void setRatesSize(long, int) {  }
#define SET_RATES_SIZE_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define SET_RATES_SIZE_METHOD "setRatesSize"
#define SET_RATES_SIZE_SIGNATURE "(JI)V"

//void execOnDeinit(long) {  }
#define EXEC_ON_DEINIT_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define EXEC_ON_DEINIT_METHOD "execOnDeinit"
#define EXEC_ON_DEINIT_SIGNATURE "(J)V"

//void execOnTick(long) {  }
#define EXEC_ON_TICK_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define EXEC_ON_TICK_METHOD "execOnTick"
#define EXEC_ON_TICK_SIGNATURE "(J)V"

//void execOnTimer(long) {  }
#define EXEC_ON_TIMER_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define EXEC_ON_TIMER_METHOD "execOnTimer"
#define EXEC_ON_TIMER_SIGNATURE "(J)V"

//bool isExecutingOnInit(long) { return false; }
#define IS_EXECUTING_ON_INIT_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define IS_EXECUTING_ON_INIT_METHOD "isExecutingOnInit"
#define IS_EXECUTING_ON_INIT_SIGNATURE "(J)Z"

//bool isExecutingOnTick(long) { return false; }
#define IS_EXECUTING_ON_TICK_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define IS_EXECUTING_ON_TICK_METHOD "isExecutingOnTick"
#define IS_EXECUTING_ON_TICK_SIGNATURE "(J)Z"

//bool isExecutingOnTimer(long) { return false; }
#define IS_EXECUTING_ON_TIMER_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define IS_EXECUTING_ON_TIMER_METHOD "isExecutingOnTimer"
#define IS_EXECUTING_ON_TIMER_SIGNATURE "(J)Z"

//bool isExecutingOnDeinit(long) { return false; }
#define IS_EXECUTING_ON_DEINIT_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define IS_EXECUTING_ON_DEINIT_METHOD "isExecutingOnDeinit"
#define IS_EXECUTING_ON_DEINIT_SIGNATURE "(J)Z"

//bool isCommandManagerReady(long) { return false; }
#define IS_COMMAND_MANAGER_READY_CLASS "com/jseppa/mql4java/base/mql/DLLObjectWrapper"
#define IS_COMMAND_MANAGER_READY_METHOD "isCommandManagerReady"
#define IS_COMMAND_MANAGER_READY_SIGNATURE "(J)Z"

//int isCommandWaiting(long) { return 0; }
#define IS_COMMAND_WAITING_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define IS_COMMAND_WAITING_METHOD "isCommandWaiting"
#define IS_COMMAND_WAITING_SIGNATURE "(J)I"

//int getCommandId(long, int) { return 0; }
#define GET_COMMAND_ID_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define GET_COMMAND_ID_METHOD "getCommandId"
#define GET_COMMAND_ID_SIGNATURE "(JI)I"

//void getCommandName(long, int, char* cmdName) {  }
#define GET_COMMAND_NAME_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define GET_COMMAND_NAME_METHOD "getCommandName"
#define GET_COMMAND_NAME_SIGNATURE "(JI)Ljava/lang/String;"

//void getCommandParams(long, int, char* cmdParams) {  }
#define GET_COMMAND_PARAMS_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define GET_COMMAND_PARAMS_METHOD "getCommandParams"
#define GET_COMMAND_PARAMS_SIGNATURE "(JI)Ljava/lang/String;"

//void setBoolCommandResponse(long, int, bool, int) {  }
#define SET_BOOL_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_BOOL_COMMAND_RESPONSE_METHOD "setBoolCommandResponse"
#define SET_BOOL_COMMAND_RESPONSE_SIGNATURE "(JIZI)V"

//void setDoubleCommandResponse(long, int, double, int) {  }
#define SET_DOUBLE_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_DOUBLE_COMMAND_RESPONSE_METHOD "setDoubleCommandResponse"
#define SET_DOUBLE_COMMAND_RESPONSE_SIGNATURE "(JIDI)V"

//void setIntCommandResponse(long, int, int, int) {  }
#define SET_INT_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_INT_COMMAND_RESPONSE_METHOD "setIntCommandResponse"
#define SET_INT_COMMAND_RESPONSE_SIGNATURE "(JIII)V"

//void setStringCommandResponse(long, int, char*, int) {  }
#define SET_STRING_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_STRING_COMMAND_RESPONSE_METHOD "setStringCommandResponse"
#define SET_STRING_COMMAND_RESPONSE_SIGNATURE "(JILjava/lang/String;I)V"

//void setVoidCommandResponse(long, int, int) {  }
#define SET_VOID_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_VOID_COMMAND_RESPONSE_METHOD "setVoidCommandResponse"
#define SET_VOID_COMMAND_RESPONSE_SIGNATURE "(JII)V"

//void setLongCommandResponse(long, int, long, int) {  }
#define SET_LONG_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_LONG_COMMAND_RESPONSE_METHOD "setLongCommandResponse"
#define SET_LONG_COMMAND_RESPONSE_SIGNATURE "(JIJI)V"

//void setDateTimeCommandResponse(long, int, long, int) {  }
#define SET_DATETIME_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define SET_DATETIME_COMMAND_RESPONSE_METHOD "setDateTimeCommandResponse"
#define SET_DATETIME_COMMAND_RESPONSE_SIGNATURE "(JIJI)V"

//void setEnumCommandResponse(long, int, int, int) {  }
#define SET_ENUM_COMMAND_RESPONSE_CLASS "com/jseppa/mql4java/base/mql/MQLExpert"
#define SET_ENUM_COMMAND_RESPONSE_METHOD "setEnumCommandResponse"
#define SET_ENUM_COMMAND_RESPONSE_SIGNATURE "(JIII)V"

//bool commandLock(long) { return false; }
#define COMMAND_LOCK_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define COMMAND_LOCK_METHOD "commandLock"
#define COMMAND_LOCK_SIGNATURE "(J)Z"

//bool commandUnlock(long) { return false; }
#define COMMAND_UNLOCK_CLASS "com/jseppa/mql4java/base/mql/MQLCommandManager"
#define COMMAND_UNLOCK_METHOD "commandUnlock"
#define COMMAND_UNLOCK_SIGNATURE "(J)Z"

struct RateInfo
{
	int64_t time;       // open date and time
	double open;        // Open price (absolute value)
	double high;        // Low price
	double low;         // High price
	double close;       // Close price
	uint64_t volume;    // tick volume
	int spread;			// spread
	uint64_t real;      // trade volume
};


using namespace std;

namespace mql4j {
	namespace java {
		/**
		 * javaStart
		 *
		 * Start java jvm thread
		 *
		 * @return true on success, false on any failure
		 */
		MQL4J_API bool javaStart();

		/**
		 * javaStop
		 *
		 * Stop java jvm thread
		 *
		 * @return true on success, false on any failure
		 */
		MQL4J_API bool javaStop();

		/**
		 * javaStatus
		 *
		 * Status of java jvm thread
		 *
		 * @return true if running, elsewhere false
		 */
		MQL4J_API bool javaStatus();

		/**
		 * javaCall
		 *
		 * Call a static java function which needs one argument.
		 * The argument and the return value is on object of class
		 * com.java.lang.String
		 */
		MQL4J_API wchar_t * javaCall(wchar_t * className, wchar_t * methodName, wchar_t * arg);


		MQL4J_API int initRates(int64_t chartId, RateInfo* arr, int arr_size);

		MQL4J_API void setRatesSize(int64_t chartId, int arr_size);

		MQL4J_API void execOnInit(int64_t chartID, wchar_t* strategyClassName);

		MQL4J_API void execOnDeinit(int64_t chartId);

		MQL4J_API void execOnTick(int64_t chartId);

		MQL4J_API void execOnTimer(int64_t chartId);

		MQL4J_API bool isExecutingOnInit(int64_t chartId);

		MQL4J_API bool isExecutingOnTick(int64_t chartId);

		MQL4J_API bool isExecutingOnTimer(int64_t chartId);

		MQL4J_API bool isExecutingOnDeinit(int64_t chartId);

		MQL4J_API bool isCommandManagerReady(int64_t chartId);

		MQL4J_API int isCommandWaiting(int64_t chartId);

		MQL4J_API int getCommandId(int64_t chartId, int id);

		MQL4J_API wchar_t* getCommandName(int64_t chartId, int id);

		MQL4J_API wchar_t* getCommandParams(int64_t chartId, int id);

		MQL4J_API void setBoolCommandResponse(int64_t chartId, int id, bool response, int error);

		MQL4J_API void setDoubleCommandResponse(int64_t chartId, int id, double response, int error);

		MQL4J_API void setIntCommandResponse(int64_t chartId, int id, int response, int error);

		MQL4J_API void setStringCommandResponse(int64_t chartId, int id, wchar_t* response, int error);

		MQL4J_API void setVoidCommandResponse(int64_t chartId, int id, int error);

		MQL4J_API void setLongCommandResponse(int64_t chartId, int id, int64_t response, int error);

		MQL4J_API void setDateTimeCommandResponse(int64_t chartId, int id, int64_t response, int error);

		MQL4J_API void setEnumCommandResponse(int64_t chartId, int id, int response, int error);

		MQL4J_API bool commandLock(int64_t chartId);

		MQL4J_API bool commandUnlock(int64_t chartId);

	}
}
