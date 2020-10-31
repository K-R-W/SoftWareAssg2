#!/bin/sh
export JAVA_HOME=/lib/jvm/java-1.8.0-openjdk-amd64
cd Memcall
javac Memcall.java
javah Memcall
gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libmemc.so MemcallIMP.c
java -Djava.library.path=. Memcall
cd ..