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
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

#pragma once
#include "Mql4jConfig.h"
#include <time.h>
#include <fstream>
#include <iostream>
#include <algorithm>

using namespace std;

namespace mql4j {
	/**
	 * Namespace log
	 *
	 * Methods for logging mql4j messages
	 */
	namespace log {
		/**
		 * Enum Level
		 *
		 * Log levels
		 */
		enum class Level { TRACE, DEBUG, INFO, WARN, ERR };

		/**
		 * Method trace
		 *
		 * Create a log message (write to logfile / display on console output)
		 * with level TRACE.
		 *
		 * This message will be ignored, if debug is not enabled in
		 * configuration
		 *
		 * @param file    name of source file (Precompiler macro __FILE__)
		 * @param line    in source file (Precompiler macro __LINE__)
		 * @param message Log text
		 */
		void trace(const string file, const int line, const string message);

		/**
		 * Method debug
		 *
		 * Create a log message (write to logfile / display on console output)
		 * with level DEBUG.
		 *
		 * This message will be ignored, if debug is not enabled in
		 * configuration
		 *
		 * @param file    name of source file (Precompiler macro __FILE__)
		 * @param line    in source file (Precompiler macro __LINE__)
		 * @param message Log text
		 */
		void debug(const string file, const int line, const string message);

		/**
		 * Method info
		 *
		 * Create a log message (write to logfile / display on console output)
		 * with level INFO.
		 *
		 * @param file    name of source file (Precompiler macro __FILE__)
		 * @param line    in source file (Precompiler macro __LINE__)
		 * @param message Log text
		 */
		void info(const string file, const int line, const string message);

		/**
		 * Method warn
		 *
		 * Create a log message (write to logfile / display on console output)
		 * with level WARN.
		 *
		 * @param file    name of source file (Precompiler macro __FILE__)
		 * @param line    in source file (Precompiler macro __LINE__)
		 * @param message Log text
		 */
		void warn(const string file, const int line, const string message);

		/**
		 * Method error
		 *
		 * Create a log message (write to logfile / display on console output)
		 * with level ERR.
		 *
		 * @param file    name of source file (Precompiler macro __FILE__)
		 * @param line    in source file (Precompiler macro __LINE__)
		 * @param message Log text
		 */
		void error(const string file, const int line, const string message);

		/**
		 * Method log
		 *
		 * Create a log message (write to logfile / display on console output)
		 * with specified level.
		 *
		 * @param file    name of source file (Precompiler macro __FILE__)
		 * @param line    in source file (Precompiler macro __LINE__)
		 * @param level   weight of log event
		 * @param message Log text
		 */
		void log(const string file, const int line, Level level, const string message);

		/**
		 * getLevelStr
		 *
		 * Converts Level to string
		 *
		 * @param  level to convert
		 *
		 * @return Representing string
		 */
		string getLevelStr(Level level);

		/**
		 * getTime
		 *
		 * Creates a formated string with current time
		 *
		 * @return formated time string
		 */
		string getTime();

		/**
		 * getOrigin
		 *
		 * Formats file and line to fixed size
		 *
		 * @param  file name
		 * @param  line number
		 *
		 * @return formated string
		 */
		string getOrigin(const string file, const int line);

		/**
		 * getConfigLogLevel
		 *
		 * Get configured log level as integer
		 *
		 * @return TRACE 0
		 *         DEBUG 1
		 *         INFO  2
		 *         WARN  3
		 *         ERROR 4
		 */
		Level getConfigLogLevel();
	}
}
