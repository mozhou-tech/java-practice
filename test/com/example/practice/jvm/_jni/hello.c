#include <jni.h>
#include <stdio.h>
#include "com_example_practice_jvm__jni_Hello.h"

JNIEXPORT void JNICALL
Java_HelloWorld_print(JNIEnv *env, jobject obj) {
	printf("Hello world!\n");
	return;
}