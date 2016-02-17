/* JavaException.cpp */
#include "stdafx.h"
#include "JavaException.h"


mql4j::java::JavaException::JavaException(JNIEnv * env) {
	this->env = env;
	this->message = "";
	if(env == NULL) {
		return;
	}
	if(!env->ExceptionCheck()) {
		return;
	}
	jthrowable exception = env->ExceptionOccurred();
	env->ExceptionClear();
	jclass throwableClass = env->FindClass("java/lang/Throwable");
	throwableGetCauseId = env->GetMethodID(throwableClass, "getCause", "()Ljava/lang/Throwable;");
	throwableGetStackTraceId = env->GetMethodID(throwableClass, "getStackTrace", "()[Ljava/lang/StackTraceElement;");
	throwableToStringId = env->GetMethodID(throwableClass, "toString", "()Ljava/lang/String;");
	jclass frameClass = env->FindClass("java/lang/StackTraceElement");
	frameToStringId = env->GetMethodID(frameClass, "toString", "()Ljava/lang/String;");
	createMessage(exception);
}

mql4j::java::JavaException::~JavaException() {
}

void mql4j::java::JavaException::createMessage(jthrowable obj) {
	jobjectArray frames = (jobjectArray) env->CallObjectMethod(obj, throwableGetStackTraceId);
	jsize framesLength = env->GetArrayLength(frames);
	if(frames != 0) {
		jstring msgObj = (jstring) env->CallObjectMethod(obj, throwableToStringId);
		const char* msgStr = env->GetStringUTFChars(msgObj, 0);
		if(!message.length() == 0) {
			message += "\nCaused by: " + string(msgStr);
		} else {
			message += string(msgStr);
		}
		env->ReleaseStringUTFChars(msgObj, msgStr);
		env->DeleteLocalRef(msgObj);
	}
	if(framesLength > 0) {
		for(jsize i = 0; i < framesLength; i++) {
			jobject frame = env->GetObjectArrayElement(frames, i);
			jstring msgObj = (jstring) env->CallObjectMethod(frame, frameToStringId);
			const char* msgStr = env->GetStringUTFChars(msgObj, 0);
			message += "\n    " + string(msgStr);
			env->ReleaseStringUTFChars(msgObj, msgStr);
			env->DeleteLocalRef(msgObj);
			env->DeleteLocalRef(frame);
		}
	}
	if(frames != 0) {
		jthrowable cause = (jthrowable) env->CallObjectMethod(obj, throwableGetCauseId);
		if(cause != 0) {
			createMessage(cause);
		}
	}
}

mql4j::java::JavaException * mql4j::java::JavaException::create(JNIEnv * env) {
	JavaException * e = new JavaException(env);
	if(e->getMessage().length() == 0) {
		delete e;
		return NULL;
	} else {
		return e;
	}
}

string mql4j::java::JavaException::getMessage() {
	return message;
}

void mql4j::java::JavaException::printMessage() {
	LOG_WARN << message;
}
