#include <jni.h>        // JNI header provided by JDK
#include <stdio.h>      // C Standard IO Header
#include <string.h>
#include <stdlib.h>
#include "Except.h"   // Generated 

JNIEXPORT void JNICALL Java_Except_catchThrow(JNIEnv *env, jobject obj){
    printf("which error would you like?\npress 1 for NullPointerException\npress 2 for Divide By Zero Exception");
    int choice;
    scanf("%d",&choice);
    if(choice==1){
        jclass newExcCls = (*env)->FindClass(env, "java/lang/NullPointerException");
        if (newExcCls == 0) { /* Unable to find the new exception class, give up. */
            return;
        }
        (*env)->ThrowNew(env, newExcCls, "Thrown a Null Exception from C code because you selected 1");
        return;   
    }
    else if(choice==2){
        jclass newExcCls = (*env)->FindClass(env, "java/lang/ArithmeticException");
        if (newExcCls == 0) { /* Unable to find the new exception class, give up. */
            return;
        }
        (*env)->ThrowNew(env, newExcCls, "Thrown a Divide By Zero Exception from C code because you selected 2");
        return;
    }
    else{
        jclass newExcCls = (*env)->FindClass(env, "java/lang/IllegalArgumentException");
        if (newExcCls == 0) { /* Unable to find the new exception class, give up. */
            return;
        }
        (*env)->ThrowNew(env, newExcCls, "I told you to select between 1 and 2, bro");
        return;
    }
}

