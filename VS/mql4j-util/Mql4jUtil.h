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


/**
 * Modification Notice From: Jason Separovic
 * Description: Removed all references to activeMQ as it's not required in MQL4Java project
 * For a detailed descirption of changes please view Pull Request: https://github.com/jseparovic/mql4j/pull/1/files
*/

#pragma once
#ifdef _LOG_DEBUG
	#define CRTDBG_MAP_ALLOC
#endif
#include "..\mql4j-common\Mql4jString.h"
#include "..\mql4j-java\Mql4jJava.h"

using namespace std;

namespace mql4j {
	/**
	 * jvmStart
	 *
	 * Start jvm
	 */
	void jvmStart();
}
