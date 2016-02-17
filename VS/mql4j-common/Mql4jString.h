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
#ifdef _LOG_DEBUG
	#pragma comment(lib, "comsuppwd.lib")
#else
	#pragma comment(lib, "comsuppw.lib")
#endif
#include <string>
#include <comutil.h>

using namespace std;

namespace mql4j {
	/**
	 * toString
	 *
	 * Convert wstring to string
	 *
	 * @param  w wstring
	 *
	 * @return string
	 */
	string toString(const wstring w);

	/**
	 * toString
	 *
	 * Convert string to wstring
	 *
	 * @param  s string
	 *
	 * @return wstring
	 */
	wstring toWString(const string s);

	/**
	 * toWArray
	 *
	 * Convert string to wchar_t *
	 *
	 * @param  s string
	 *
	 * @return wchar_t *
	 */
	wchar_t * toWArray(const string s);
}
