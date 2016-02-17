/* JavaMethodDesc.cpp */
#include "stdafx.h"
#include "JavaMethodDesc.h"

mql4j::java::JavaMethodDesc::JavaMethodDesc(const string className, const string methodName) {
	this->argc = 0;
	this->sign = "(";
	this->className = className;
	this->methodName = methodName;
	std::replace(this->className.begin(), this->className.end(), '.', '/');
}

mql4j::java::JavaMethodDesc::~JavaMethodDesc() {
}

void mql4j::java::JavaMethodDesc::add(Jid id) {
	argc++;
	sign += getIdString(id);
}

void mql4j::java::JavaMethodDesc::addArray(Jid id) {
	argc++;
	sign += "[";
	sign += getIdString(id);
}

void mql4j::java::JavaMethodDesc::setReturn(Jid id) {
	sign += ")";
	sign += getIdString(id);
}

int mql4j::java::JavaMethodDesc::getArgc() {
	return argc;
}

string mql4j::java::JavaMethodDesc::getSignature() {
	return sign;
}

string mql4j::java::JavaMethodDesc::getClassName() {
	return className;
}

string mql4j::java::JavaMethodDesc::getMethodName() {
	return methodName;
}

string mql4j::java::JavaMethodDesc::getIdString(Jid id) {
	switch(id) {
		case Jid::POJOboolean:
			return "Z";
		case Jid::POJObyte:
			return "B";
		case Jid::POJOchar:
			return "C";
		case Jid::POJOdouble:
			return "D";
		case Jid::POJOfloat:
			return "F";
		case Jid::POJOint:
			return "I";
		case Jid::POJOlong:
			return "J";
		case Jid::POJOshort:
			return "S";
		case Jid::Boolean:
			return "Ljava/lang/Boolean;";
		case Jid::Byte:
			return "Ljava/lang/Byte;";
		case Jid::Character:
			return "Ljava/lang/Character;";
		case Jid::Integer:
			return "Ljava/lang/Integer;";
		case Jid::Double:
			return "Ljava/lang/Double;";
		case Jid::Long:
			return "Ljava/lang/Long;";
		case Jid::Float:
			return "Ljava/lang/Float;";
		case Jid::Short:
			return "Ljava/lang/Short;";
		case Jid::String:
			return "Ljava/lang/String;";
		case Jid::Void:
			return "V";
		default:
			return "INVALID_ID";
	}
}
