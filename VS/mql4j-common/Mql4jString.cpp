/* Mql4jString.cpp */
#include "stdafx.h"
#include "Mql4jString.h"

string mql4j::toString(const wstring w) {
	_bstr_t bstr(w.c_str());
	return string(bstr);
}

wstring mql4j::toWString(const string s) {
	return std::wstring(s.begin(), s.end());
}

wchar_t * mql4j::toWArray(const string s) {
	wstring ws = toWString(s);
	size_t size = (ws.length() + 1) * 2;
	wchar_t * w = new wchar_t[size]();
	memcpy_s(w, size, ws.c_str(), size);
	return w;
}
