// Save as "HelloJNI.c"
#include <jni.h>        // JNI header provided by JDK
#include <stdio.h>      // C Standard IO Header
#include <string.h>
#include "Palindrome.h"   // Generated
 
// Implementation of the native method sayHello()
JNIEXPORT jboolean JNICALL Java_Palindrome_palin(JNIEnv *env, jobject thisObj, jstring str) {
   const char *path;
   path = (*env)->GetStringUTFChars( env, str, NULL);
   int l = 0; 
   int h = strlen(path) - 1; 
   int ret=1; 
   // Keep comparing characters while they are same 
   while (h > l) 
   { 
      if (path[l++] != path[h--]) 
      { 
          
         ret=0; 
      } 
   }
   
   (*env)->ReleaseStringUTFChars(env, str, path);
   return ret; 


}