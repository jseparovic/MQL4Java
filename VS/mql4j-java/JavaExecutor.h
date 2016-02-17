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
#include "JavaException.h"
#include "JavaMethodDesc.h"
#include <cstdarg>
#include <jni.h>
#include "..\mql4j-common\Mql4jCommon.h"


using namespace std;

namespace mql4j {
	namespace java {

		class JavaExecutor {
		  public:
			static jclass getJClass(JNIEnv * env, const char* classNameStr);

			static jmethodID getJMethodID(JNIEnv * env, jclass classHandle, const char*  methodName, const char*  signature);

			static jstring toJString(JNIEnv *env, wchar_t *str);

			static bool callBoolMethod(int64_t chartId, const char* className, const char* methodName, const char* signature);

			static void callVoidMethod(int64_t chartId, const char* className, const char* methodName, const char* signature);

		};
	}
}
