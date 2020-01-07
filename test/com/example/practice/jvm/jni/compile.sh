# 头文件
rm -f ./*.jnilib
rm -f ./*.h
rm -f ./*.class
sleep 1
javac -h . JNIExample.java
# 编译为.so库
gcc -I"/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/include" -I"/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/include/darwin" -lc -shared -o JNITest.jnilib JNITest.c
# 手工修改hello.c中的头
java -Djava.library.path=. JNIExample.java