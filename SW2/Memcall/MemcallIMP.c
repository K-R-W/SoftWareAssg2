// Save as "HelloJNI.c"
#include <jni.h>        // JNI header provided by JDK
#include <stdio.h>      // C Standard IO Header
#include <string.h>
#include <stdlib.h>
#include "Memcall.h"   // Generated 


JNIEXPORT void JNICALL Java_Memcall_call(JNIEnv *env, jobject obj){
    printf("We are now in C\n");
    jclass cls = (*env)->GetObjectClass(env, obj);
    jmethodID mid = (*env)->GetStaticMethodID(env, cls, "staticcall", "()V");
    jmethodID ocl = (*env)->GetMethodID(env, cls, "objectcall", "()V");
    

    (*env)->CallStaticVoidMethod(env, obj, mid);
    (*env)->CallVoidMethod(env, obj, ocl);
    
    jfieldID fid = (*env)->GetStaticFieldID(env, cls, "Pin", "I");
    jint npin;
    printf("Enter a new Pin: ");
    scanf("%d",&npin);
    (*env)->SetStaticIntField(env, cls, fid, npin);
    (*env)->CallStaticVoidMethod(env, obj, mid);


    printf("We are going back to Java now\n");
}