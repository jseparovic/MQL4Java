/* Mql4j-util.cpp */
#include "stdafx.h"
#include "Mql4jUtil.h"

void mql4j::jvmStart() {
	if(!java::javaStart()) {
		exit(1);
	}
}

void printHelp() {
	printf_s("Usage: \n");
	printf_s("  jvmStart\n");
	printf_s("  help\n");
	printf_s("\n");
	exit(1);
}

string getArg(const int argc, const char * argv[], const int num) {
	if(num >= argc) {
		printf_s("To few arguments!\nSee %s help\n", argv[0]);
		exit(1);
	}
	return string(argv[num]);
}

int main(int argc, const char* argv[]) {
	if(argc < 2) {
		printHelp();
	}
	const string func = getArg(argc, argv, 1);
	if(func.compare("help") == 0) {
		printHelp();
	} else if(func.compare("jvmStart") == 0) {
		mql4j::jvmStart();
	} else {
		printHelp();
	}
	return 0;
}
