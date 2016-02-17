/* JavaExecutor.cpp */
#include "stdafx.h"
#include "JavaExecutor.h"
#include "boost/format.hpp"
#include "boost/locale.hpp"


jclass mql4j::java::JavaExecutor::getJClass(JNIEnv * env, const char* classNameStr) {
	jclass classHandle = env->FindClass(classNameStr);
	if (classHandle == NULL)
	{
		LOG_ERROR << boost::format("could not find class :  %1%") % classNameStr;
		return NULL;
	}
	return classHandle;
}


jmethodID mql4j::java::JavaExecutor::getJMethodID(JNIEnv * env, jclass classHandle, const char*  methodName, const char*  signature) {
	jmethodID methodID = env->GetStaticMethodID(classHandle, methodName, signature);
	if (methodID == NULL)
	{
		LOG_ERROR << boost::format("could not find method :  %1% %2%") % methodName % signature;
		return NULL;
	}
	return methodID;
}

jstring mql4j::java::JavaExecutor::toJString(JNIEnv *env, wchar_t *str) {
	return env->NewStringUTF(toString(str).c_str());
}


bool mql4j::java::JavaExecutor::callBoolMethod(int64_t chartId, const char* className, const char* methodName, const char* signature)
{
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return true;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return true;

	bool result = env->CallStaticBooleanMethod(classHandle, methodID, chartId);
	LOG_DEBUG << boost::format("Call %1% %2%(%3%) returns %4%") % className % methodName % chartId % result;
	return result;
}


void mql4j::java::JavaExecutor::callVoidMethod(int64_t chartId, const char* className, const char* methodName, const char* signature)
{
	LOG_DEBUG << boost::format("calling %1%") % methodName;

	JNIEnv * env = JavaJvm::instance()->getEnv();
	jclass classHandle = JavaExecutor::getJClass(env, className);
	if (classHandle == NULL) return;

	jmethodID methodID = JavaExecutor::getJMethodID(env, classHandle, methodName, signature);
	if (methodID == NULL) return;

	env->CallStaticVoidMethod(classHandle, methodID, chartId);
	LOG_DEBUG << boost::format("Call %1% %2%(%3%)") % className % methodName % chartId;
}
