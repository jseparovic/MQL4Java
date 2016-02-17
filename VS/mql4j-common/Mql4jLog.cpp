/* Mql4jLog.cpp */
#include "stdafx.h"
#include "Mql4jLog.h"

void mql4j::log::trace(const string file, const int line, const string message) {
	log(file, line, Level::TRACE, message);
}

void mql4j::log::debug(const string file, const int line, const string message) {
	log(file, line, Level::DEBUG, message);
}

void mql4j::log::info(const string file, const int line, const string message) {
	log(file, line, Level::INFO, message);
}

void mql4j::log::warn(const string file, const int line, const string message) {
	log(file, line, Level::WARN, message);
}

void mql4j::log::error(const string file, const int line, const string message) {
	log(file, line, Level::ERR, message);
}

void mql4j::log::log(const string file, const int line, Level level, const string message) {
	if(level < getConfigLogLevel()) {
		return;
	}
	string logOrigin = getOrigin(file, line);
	string logEntry = getTime() + " " + getLevelStr(level) + " " + getOrigin(file, line) + " " + message + "\n";
	cout << logEntry;
	ofstream logFile(config::getLogfile(), ofstream::out | ofstream::app);
	if(logFile.bad()) {
		printf_s("Failed to write logfile\n");
	} else {
		logFile.write(logEntry.c_str(), logEntry.length());
		logFile.close();
	}
}

string mql4j::log::getLevelStr(Level level) {
	switch(level) {
		case Level::TRACE:
			return "[ TRACE ]";
			break;
		case Level::DEBUG:
			return "[ DEBUG ]";
			break;
		case Level::INFO:
			return "[ INFO  ]";
			break;
		case Level::WARN:
			return "[ WARN  ]";
			break;
		case Level::ERR:
			return "[ ERROR ]";
			break;
		default:
			return NULL;
	}
}

string mql4j::log::getTime() {
	time_t t = time(0);
	struct tm tm;
	localtime_s(&tm, &t);
	char buffer[20];
	sprintf_s(buffer, 20, "%04d-%02d-%02d %02d:%02d:%02d", tm.tm_year + 1900,
	          tm.tm_mon + 1, tm.tm_mday, tm.tm_hour, tm.tm_min, tm.tm_sec);
	return string(buffer);
}

string mql4j::log::getOrigin(const string file, const int line) {
	size_t pos = file.find_last_of("\\");
	string f, origin;
	if(pos != string::npos) {
		f = file.substr(pos + 1);
	} else {
		f = file;
	}
	origin = f + ":" + to_string(line);
	if(origin.length() > 30) {
		origin = origin.substr(0, 27) + "...";
	}
	while(origin.length() < 30) {
		origin += " ";
	}
	return origin;
}

mql4j::log::Level mql4j::log::getConfigLogLevel() {
	string configLogLevel = config::getLogLevel();
	transform(configLogLevel.begin(), configLogLevel.end(), configLogLevel.begin(), ::toupper);
	if(configLogLevel.compare("TRACE") == 0) {
		return Level::TRACE;
	} else if(configLogLevel.compare("DEBUG") == 0) {
		return Level::DEBUG;
	} else if(configLogLevel.compare("INFO") == 0) {
		return Level::INFO;
	} else if(configLogLevel.compare("WARN") == 0) {
		return Level::WARN;
	} else if(configLogLevel.compare("ERR") == 0) {
		return Level::ERR;
	} else if(configLogLevel.compare("ERROR") == 0) {
		return Level::ERR;
	} else {
		return Level::INFO;
	}
}
