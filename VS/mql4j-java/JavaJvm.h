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
#include "..\mql4j-common\Mql4jConfig.h"
#include "..\mql4j-common\Mql4jString.h"
#include "JavaExecutor.h"
#include "JavaException.h"
#include <jni.h>
#include "..\mql4j-common\Mql4jCommon.h"


#define JVM_OPTS_MAX 50
#define JVM_OPT_LEN_MAX 1024
#define JVM_VERBOSE_CLASSLOADER true
#define JVM_VERBOSE_JNI true
#define JVM_JAVA_VERSION_REQ JNI_VERSION_1_8

namespace mql4j {
	namespace java {
		/**
		 * Class JavaJvm
		 *
		 * Manages a java virtual machine (JVM) using the java native
		 * interface (JNI).
		 *
		 * Singleton
		 */
		class JavaJvm {
		  private:
			/**
			 * Singleton instance
			 */
			static JavaJvm * _instance;

			/**
			 * Java JVM environment
			 */
			JNIEnv * env;

			/**
			 * Java JVM habdle
			 */
			JavaVM * jvm;

			/**
			 * Number of JVM startup arguments
			 */
			size_t nOptions;

			/**
			 * List of JVM startup arguments
			 */
			JavaVMOption * options;

		  private:
			/**
			 * Constructor
			 *
			 * Private access for singleton
			 */
			JavaJvm();

			/**
			 * Destructor
			 *
			 * Private access for singleton
			 */
			virtual ~JavaJvm();

		  public:
			/**
			 * instance
			 *
			 * Access singleton instance
			 *
			 * @return Singleton instance
			 */
			static JavaJvm * instance();

			/**
			 * release
			 *
			 * Release singleton instance
			 */
			static void release();

			/**
			 * getEnv
			 *
			 * Get java JVM environment variable
			 *
			 * @return JVM environment
			 */
			JNIEnv * getEnv();

			/**
			 * start
			 *
			 * Start the java JVM thread
			 *
			 * @return true on success, false on any failure
			 */
			bool start();

			/**
			 * stop
			 *
			 * Stop the java JVM thread
			 *
			 * @return true on success, false on any failure
			 */
			bool stop();

			/**
			 * isRunning
			 *
			 * Check if java JVM thread is running
			 *
			 * @return true if running, elsewhere false
			 */
			bool isRunning();

		  private:
			/**
			 * attach
			 *
			 * If jvm is created by another thread, it is required to attach the JVM to
			 * the current thread
			 *
			 * @return true if successfully attached jvm, elsewhere false
			 */
			bool attach();

			/**
			 * getClassPath
			 *
			 * Looks for each jar file in configured home directory and creates
			 * the classpath explicit including each of them with full
			 * qualified path.
			 *
			 * @return classpath argument string for JVM start
			 */
			string getClassPath();

			/**
			 * addOption
			 *
			 * Adds an option to the list of JVM startup options
			 *
			 * @param  option string
			 */
			void addOption(const string option);

			/**
			 * getErrorStr
			 *
			 * Converts the JVM create / destroy / ... result codes to
			 * the representing string
			 *
			 * @param  rc result code
			 *
			 * @return error string
			 */
			string getErrorStr(const jint rc);
		};
	}
}
