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
#include <string>
#include <algorithm>
#include "..\mql4j-common\Mql4jCommon.h"


using namespace std;

namespace mql4j {
	namespace java {
		/**
		 * Enum Jid
		 *
		 * IDs of java POJO types and most common objects
		 */
		enum class Jid {
			POJOboolean,
			POJObyte,
			POJOchar,
			POJOdouble,
			POJOfloat,
			POJOint,
			POJOlong,
			POJOshort,
			Boolean,
			Byte,
			Character,
			Integer,
			Double,
			Long,
			Float,
			Short,
			String,
			Void
		};
		/**
		 * Class JavaMethodDesc
		 *
		 * Generator for java / JNI method signatures
		 */
		class JavaMethodDesc {
		  private:
			int argc;
			string sign;
			string className;
			string methodName;
		  public:
			/**
			 * Constructor
			 *
			 * @param className Full path including package
			 * @param methodName
			 */
			JavaMethodDesc(const string className, const string methodName);

			/**
			 * Destructor
			 *
			 */
			~JavaMethodDesc();

			/**
			 * add
			 *
			 * Add a method argument
			 *
			 * @param id
			 */
			void add(Jid id);

			/**
			 * add
			 *
			 * Add a method argument as array
			 *
			 * @param id
			 */
			void addArray(Jid id);

			/**
			 * setReturn
			 *
			 * Set the method return type
			 *
			 * @param id
			 */
			void setReturn(Jid id);

			/**
			 * getArgc
			 *
			 * Get the total amount of method arguments
			 *
			 * @return count
			 */
			int getArgc();

			/**
			 * getSignature
			 *
			 * Get the full java / JNI method signature
			 * For details, see https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/types.html
			 *
			 * @return signature
			 */
			string getSignature();

			/**
			 * getClassName
			 *
			 * Get the class name
			 *
			 * @return className
			 */
			string getClassName();

			/**
			 * getMethodName
			 *
			 * Get the method name
			 *
			 * @return methodName
			 */
			string getMethodName();
		  private:
			/**
			 * getIdString
			 *
			 * Get the java / JNI signature string of a POJO or common okject
			 * type
			 *
			 * @return count
			 */
			string getIdString(Jid id);
		};
	}
}
