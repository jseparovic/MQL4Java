/* Mql4jJava.cpp */
#include "stdafx.h"
#include "Mql4jJava.h"
#include "boost/format.hpp"

#define MINUS_ONE -1

MQL4J_API bool mql4j::java::javaStart() {
	if(!java::JavaJvm::instance()->start()) {
		return false;
	}
	JNIEnv * env = JavaJvm::instance()->getEnv();
	return true;
}

MQL4J_API bool mql4j::java::javaStop() {
	LOG_WARN << "Unloading JVM is not possible. You need to restart the terminal";
	return true;
}

MQL4J_API bool mql4j::java::javaStatus() {
	return JavaJvm::instance()->isRunning();
}


MQL4J_API int mql4j::java::initRates(int64_t chartId, RateInfo* arr, int arr_size)
{
	// TODO: can this be supported?
	return 0;
}

MQL4J_API void mql4j::java::setRatesSize(int64_t chartId, int strategyClassName)
{
	// TODO: can this be supported?
}

MQL4J_API void mql4j::java::execOnInit(int64_t chartId, wchar_t *strategyClassName) {
	const char* className = EXEC_ON_INIT_CLASS;
	const char* methodName = EXEC_ON_INIT_METHOD;
	const char* signature = EXEC_ON_INIT_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, JavaExecutor::toJString(env, strategyClassName));
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%,%4%)") % className % methodName % chartId % strategyClassName);
}

MQL4J_API void mql4j::java::execOnDeinit(int64_t chartId)
{
	JavaExecutor::callVoidMethod(chartId, EXEC_ON_DEINIT_CLASS, EXEC_ON_DEINIT_METHOD, EXEC_ON_DEINIT_SIGNATURE);
}

MQL4J_API void mql4j::java::execOnTick(int64_t chartId)
{
	JavaExecutor::callVoidMethod(chartId, EXEC_ON_TICK_CLASS, EXEC_ON_TICK_METHOD, EXEC_ON_TICK_SIGNATURE);
}

MQL4J_API void mql4j::java::execOnTimer(int64_t chartId)
{
	JavaExecutor::callVoidMethod(chartId, EXEC_ON_TIMER_CLASS, EXEC_ON_TIMER_METHOD, EXEC_ON_TIMER_SIGNATURE);
}

MQL4J_API bool mql4j::java::isExecutingOnInit(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, IS_EXECUTING_ON_INIT_CLASS, IS_EXECUTING_ON_INIT_METHOD, IS_EXECUTING_ON_INIT_SIGNATURE);
}

MQL4J_API bool mql4j::java::isExecutingOnTick(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, IS_EXECUTING_ON_TICK_CLASS, IS_EXECUTING_ON_TICK_METHOD, IS_EXECUTING_ON_TICK_SIGNATURE);
}

MQL4J_API bool mql4j::java::isExecutingOnTimer(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, IS_EXECUTING_ON_TIMER_CLASS, IS_EXECUTING_ON_TIMER_METHOD, IS_EXECUTING_ON_TIMER_SIGNATURE);
}

MQL4J_API bool mql4j::java::isExecutingOnDeinit(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, IS_EXECUTING_ON_DEINIT_CLASS, IS_EXECUTING_ON_DEINIT_METHOD, IS_EXECUTING_ON_DEINIT_SIGNATURE);
}

MQL4J_API bool mql4j::java::isCommandManagerReady(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, IS_COMMAND_MANAGER_READY_CLASS, IS_COMMAND_MANAGER_READY_METHOD, IS_COMMAND_MANAGER_READY_SIGNATURE);
}

MQL4J_API int mql4j::java::isCommandWaiting(int64_t chartId)
{
	const char* className = IS_COMMAND_WAITING_CLASS;
	const char* methodName = IS_COMMAND_WAITING_METHOD;
	const char* signature = IS_COMMAND_WAITING_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return MINUS_ONE;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return MINUS_ONE;

	int result = env->CallStaticIntMethod(classHandle, methodID, chartId);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%) returns %4%") % className % methodName % chartId % result);
	return result;
}

MQL4J_API int mql4j::java::getCommandId(int64_t chartId, int id)
{
	const char* className = GET_COMMAND_ID_CLASS;
	const char* methodName = GET_COMMAND_ID_METHOD;
	const char* signature = GET_COMMAND_ID_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return MINUS_ONE;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return MINUS_ONE;

	int result = env->CallStaticIntMethod(classHandle, methodID, chartId, id);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%) returns %5%") % className % methodName % chartId % id % result);
	return result;

}

MQL4J_API wchar_t* mql4j::java::getCommandName(int64_t chartId, int id)
{
	const char* className = GET_COMMAND_NAME_CLASS;
	const char* methodName = GET_COMMAND_NAME_METHOD;
	const char* signature = GET_COMMAND_NAME_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return L"ERROR: class error";

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return L"ERROR: method error";

	jstring retval = (jstring) env->CallStaticObjectMethod(classHandle, methodID, chartId, id);
	wchar_t * commandName = (wchar_t *)env->GetStringChars(retval, NULL);
	env->ReleaseStringChars(retval, (jchar *)commandName);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%) returns %5%") % className % methodName % chartId % id % commandName);
	return commandName;
}

MQL4J_API wchar_t* mql4j::java::getCommandParams(int64_t chartId, int id)
{
	const char* className = GET_COMMAND_PARAMS_CLASS;
	const char* methodName = GET_COMMAND_PARAMS_METHOD;
	const char* signature = GET_COMMAND_PARAMS_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return L"ERROR: class error";

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return L"ERROR: method error";

	jstring retval = (jstring)env->CallStaticObjectMethod(classHandle, methodID, chartId, id);
	wchar_t * params = (wchar_t *)env->GetStringChars(retval, NULL);
	env->ReleaseStringChars(retval, (jchar *)params);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%) returns %5%") % className % methodName % chartId % id % params);
	return params;
}

MQL4J_API void mql4j::java::setBoolCommandResponse(int64_t chartId, int id, bool response, int error)
{
	const char* className = SET_BOOL_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_BOOL_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_BOOL_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, response, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API void mql4j::java::setDoubleCommandResponse(int64_t chartId, int id, double response, int error)
{
	const char* className = SET_DOUBLE_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_DOUBLE_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_DOUBLE_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, response, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API void mql4j::java::setIntCommandResponse(int64_t chartId, int id, int response, int error)
{
	const char* className = SET_INT_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_INT_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_INT_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, response, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API void mql4j::java::setStringCommandResponse(int64_t chartId, int id, wchar_t* response, int error)
{
	const char* className = SET_STRING_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_STRING_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_STRING_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, JavaExecutor::toJString(env, response), error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API void mql4j::java::setVoidCommandResponse(int64_t chartId, int id, int error)
{
	const char* className = SET_VOID_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_VOID_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_VOID_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%)") % className % methodName % chartId % id % error);
}

MQL4J_API void mql4j::java::setLongCommandResponse(int64_t chartId, int id, int64_t response, int error)
{
	const char* className = SET_LONG_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_LONG_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_LONG_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, response, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API void mql4j::java::setDateTimeCommandResponse(int64_t chartId, int id, int64_t response, int error)
{
	const char* className = SET_DATETIME_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_DATETIME_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_DATETIME_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, response, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API void mql4j::java::setEnumCommandResponse(int64_t chartId, int id, int response, int error)
{
	const char* className = SET_ENUM_COMMAND_RESPONSE_CLASS;
	const char* methodName = SET_ENUM_COMMAND_RESPONSE_METHOD;
	const char* signature = SET_ENUM_COMMAND_RESPONSE_SIGNATURE;
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId, id, response, error);
	LOG_DEBUG << boost::str(boost::wformat(L"Call %1% %2%(%3%, %4%, %5%, %6%)") % className % methodName % chartId % id % response % error);
}

MQL4J_API bool mql4j::java::commandLock(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, COMMAND_LOCK_CLASS, COMMAND_LOCK_METHOD, COMMAND_LOCK_SIGNATURE);
}

MQL4J_API bool mql4j::java::commandUnlock(int64_t chartId)
{
	return JavaExecutor::callBoolMethod(chartId, COMMAND_UNLOCK_CLASS, COMMAND_UNLOCK_METHOD, COMMAND_UNLOCK_SIGNATURE);
}

BOOL APIENTRY DllMain(HMODULE hModule, DWORD ul_reason_for_call, LPVOID lpReserved) {
	return true;
}
 