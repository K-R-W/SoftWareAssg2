#!/bin/sh
export JAVA_HOME=/lib/jvm/java-1.8.0-openjdk-amd64
javac Sorting.java
javah Sorting
gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libsort.so SortingIMP.c
java -Djava.library.path=. Sorting