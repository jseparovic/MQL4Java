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

#pragma once
#include "Mql4jLog.h"
#include "Mql4jString.h"
#include <algorithm>

/**
 * Configuration defaults
 */
#define MQL4J_CONFIG_LINE_MAX							2048
#define MQL4J_CONFIG_FILE								"mql4j.ini"
#define MQL4J_CONFIG_APPNAME							"mql4j"
#define MQL4J_CONFIG_DEFAULT_HOME_DIR					"C:\\trading\\jtrader\\"
#define MQL4J_CONFIG_DEFAULT_JAVA_CLASSLOADER_VERBOSE	true
#define MQL4J_CONFIG_DEFAULT_JAVA_JNI_VERBOSE			true
#define MQL4J_CONFIG_DEFAULT_JAVA_MAX_MEM				"1024m"
#define MQL4J_CONFIG_DEFAULT_LOGFILE					"mql4j.log"
#define MQL4J_CONFIG_DEFAULT_LOGLEVEL					"LOG_DEBUG"

using namespace std;

namespace mql4j {
	/**
	 * Namespace config
	 *
	 * Methods to Read / write configuration values to configuration ini file
	 * Use default values if file not found or value not set.
	 */
	namespace config {
		/**
		 * getConfigString
		 *
		 * Read a configuration string value
		 *
		 * @param  key  Configuration key
		 * @param  dflt Default value if not found in configuration file
		 *
		 * @return Configuration value as string
		 */
		string getConfigString(const string key, const string dflt);

		/**
		 * getConfigBool
		 *
		 * Read a configuration string value
		 * Converts true / false (case insensitive) to boolean
		 *
		 * @param  key  Configuration key
		 * @param  dflt Default value if not found in configuration file
		 *
		 * @return true or false
		 */
		bool getConfigBool(const string key, const bool dflt);

		/**
		 * setConfigString
		 *
		 * Write string value to configuration
		 *
		 * @param  key   Configuration key
		 * @param  value Configuration value
		 */
		void setConfigString(const string key, const string value);

		/**
		 * setConfigBool
		 *
		 * Write bool value to configuration as string true or false
		 *
		 * @param  key   Configuration key
		 * @param  value Configuration value
		 */
		void setConfigBool(const string key, const bool value);

		/**
		 * printConfig
		 *
		 * Print / log current configuration
		 */
		void printConfig();

		/**
		 * getHomeDir
		 *
		 * Get configuration for key homeDir
		 *
		 * @return configuration value
		 */
		string getHomeDir();

		/**
		 * isJavaClassloaderVerbose
		 *
		 * Get configuration for key javaClassloaderVerbose
		 *
		 * @return configuration value
		 */
		bool isJavaClassloaderVerbose();

		/**
		 * isJavaJNIVerbose
		 *
		 * Get configuration for key javaJNIVerbose
		 *
		 * @return configuration value
		 */
		bool isJavaJNIVerbose();

		/**
		 * getJavaMaxMem
		 *
		 * Get configuration for key javaMaxMem
		 *
		 * @return configuration value
		 */
		string getJavaMaxMem();

		/**
		 * getLogfile
		 *
		 * Get configuration for key logfile
		 *
		 * @return configuration value
		 */
		string getLogfile();

		/**
		 * getLogLevel
		 *
		 * Get configuration for key debug
		 *
		 * @return configuration value
		 */
		string getLogLevel();

		/**
		 * setHomeDir
		 *
		 * Set configuration for key homeDir
		 *
		 * @param b Configuration value
		 */
		void setHomeDir(const string str);

		/**
		 * setJavaClassloaderVerbose
		 *
		 * Set configuration for key jJavaClassloaderVerbose
		 *
		 * @param b Configuration value
		 */
		void setJavaClassloaderVerbose(const bool b);

		/**
		 * setJavaJNIVerbose
		 *
		 * Set configuration for key javaJNIVerbose
		 *
		 * @param b Configuration value
		 */
		void setJavaJNIVerbose(const bool b);

		/**
		 * setJavaMaxMem
		 *
		 * Set configuration for key javaMaxMem
		 *
		 * @param b Configuration value
		 */
		void setJavaMaxMem(const string str);

		/**
		 * setLogfile
		 *
		 * Set configuration for key logfile
		 *
		 * @param b Configuration value
		 */
		void setLogfile(const string str);

		/**
		 * setLogLevel
		 *
		 * Set configuration for key logLevel
		 *
		 * @param b Configuration value
		 */
		void setLogLevel(const string str);
	}
}
