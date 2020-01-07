# 头文件
javac -h . Hello.java

# 编译为.so库
gcc -I"/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/include" -I"/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/include/darwin" -lc -shared -o libHello.so Hello.c

# 手工修改hello.c中的头
