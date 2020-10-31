#!/bin/sh
export JAVA_HOME=/lib/jvm/java-1.8.0-openjdk-amd64
javac Except.java
javah Except
gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libexcept.so ExceptIMP.c
java -Djava.library.path=. Except