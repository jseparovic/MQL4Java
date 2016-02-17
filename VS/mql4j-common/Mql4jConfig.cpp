/* Mql4jConfig.cpp */
#include "stdafx.h"
#include "Mql4jConfig.h"
#include "Mql4jCommon.h"

string mql4j::config::getConfigString(const string key, const string dflt) {
	LPTSTR str = new TCHAR[MQL4J_CONFIG_LINE_MAX];
	GetPrivateProfileString(toWArray(MQL4J_CONFIG_APPNAME), toWArray(key), toWArray(dflt), str, MQL4J_CONFIG_LINE_MAX,
	                        toWArray(MQL4J_CONFIG_FILE));
	return toString(str);
}

bool mql4j::config::getConfigBool(const string key, const bool dflt) {
	string str = getConfigString(key, dflt ? "true" : "false");
	transform(str.begin(), str.end(), str.begin(), ::toupper);
	if(str.compare("TRUE") == 0) {
		return true;
	} else if(str.compare("FALSE") == 0) {
		return false;
	} else {
		LOG_WARN << "Configuration '" + key + "' (" + str + ") is invalid. Set to true or false";
		return false;
	}
}

void mql4j::config::setConfigString(const string key, const string value) {
	WritePrivateProfileString(toWArray(MQL4J_CONFIG_APPNAME), toWArray(key), toWArray(value), toWArray(MQL4J_CONFIG_FILE));
}

void mql4j::config::setConfigBool(const string key, const bool value) {
	if(value) {
		setConfigString(key, "true");
	} else {
		setConfigString(key, "false");
	}
}

void mql4j::config::printConfig() {
	LOG_INFO << "homeDir    = " + getHomeDir();
	LOG_INFO << "javaMaxMem = " + getJavaMaxMem();
	LOG_INFO << "logfile    = " + getLogfile();
	LOG_INFO << "logLevel   = " + getLogLevel();
}

string mql4j::config::getHomeDir() {
	return getConfigString("homeDir", MQL4J_CONFIG_DEFAULT_HOME_DIR);
}

bool mql4j::config::isJavaClassloaderVerbose() {
	return getConfigBool("javaClassloaderVerbose", MQL4J_CONFIG_DEFAULT_JAVA_CLASSLOADER_VERBOSE);
}

bool mql4j::config::isJavaJNIVerbose() {
	return getConfigBool("javaJNIVerbose", MQL4J_CONFIG_DEFAULT_JAVA_JNI_VERBOSE);
}

string mql4j::config::getJavaMaxMem() {
	return getConfigString("javaMaxMem", MQL4J_CONFIG_DEFAULT_JAVA_MAX_MEM);
}

string mql4j::config::getLogfile() {
	return getConfigString("logfile", MQL4J_CONFIG_DEFAULT_LOGFILE);
}

string mql4j::config::getLogLevel() {
	return getConfigString("logLevel", MQL4J_CONFIG_DEFAULT_LOGLEVEL);
}

void mql4j::config::setHomeDir(const string str) {
	setConfigString("homeDir", str);
}

void mql4j::config::setJavaClassloaderVerbose(const bool b) {
	setConfigBool("javaClassloaderVerbose", b);
}

void mql4j::config::setJavaJNIVerbose(const bool b) {
	setConfigBool("javaJNIVerbose", b);
}

void mql4j::config::setJavaMaxMem(const string str) {
	setConfigString("javaMaxMem", str);
}

void mql4j::config::setLogfile(const string str) {
	setConfigString("logfile", str);
}

void mql4j::config::setLogLevel(const string str) {
	setConfigString("logLevel", str);
}
