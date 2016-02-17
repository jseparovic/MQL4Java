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
#include "JavaJvm.h"
#include <iostream>
#include <algorithm>
#include <sstream>
#include <jni.h>
#include "..\mql4j-common\Mql4jCommon.h"


using namespace std;

namespace mql4j {
	namespace java {
		/**
		 * Class JavaException
		 *
		 * Generic object implementation of java exception
		 */
		class JavaException {
		  private:
			JNIEnv * env;
			string message;
			jmethodID throwableGetCauseId;
			jmethodID throwableGetStackTraceId;
			jmethodID throwableToStringId;
			jmethodID frameToStringId;

		  private:
			/**
			 * Constructor
			 *
			 * @param env Java JVM environment
			 */
			JavaException(JNIEnv * env);

			/**
			 * createMessage
			 *
			 * Reads java exception and cause(s)
			 *
			 * @param obj Object exception or cause
			 */
			void createMessage(jthrowable obj);

		  public:
			/**
			 * Destructor
			 */
			virtual ~JavaException();

			/**
			 * create
			 *
			 * Gets the current exception from jvm and creates generic
			 * exception object
			 *
			 * @param  env Java JVM environment
			 *
			 * @return Object of class JavaException or NULL if there is no
			 * current java exception
			 */
			static JavaException * create(JNIEnv * env);

			/**
			 * getMessage
			 *
			 * Get the full exception message including stack and cause(s)
			 *
			 * @return string
			 */
			string getMessage();

			/**
			 * printMessage
			 *
			 * Creates a log message of full exception message including
			 * stack and cause(s)
			 *
			 * @return string
			 */
			void printMessage();
		};
	}
}
