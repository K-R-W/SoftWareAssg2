
export JAVA_HOME=/lib/jvm/java-1.8.0-openjdk-amd64
gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libpalin.so PalindromeIMP.c
java -Djava.library.path=. Palindrome