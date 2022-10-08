
FileTest-- File类的使用
FileReaderWriterTest--字符输入输出流
FileInputOutputStreamTest--字节输入输出流
BufferedTest--处理流之一：缓冲流
InputStreamReaderTest--处理流之二：转换流
ObjectStream--处理流之三：对象流
OtherStreamTest--处理流之四：其他流【1.标准的输入、输出流；2.打印流；3.数据流】
RandomAccessFileTest--随机



垃圾回收机制关键点

垃圾回收机制只回收JVM堆内存里的对象空间。

对其他物理连接，比如数据库连接、输入流输出流、Socket连接无能为力

现在的JVM有多种垃圾回收实现算法，表现各异。

垃圾回收发生具有不可预知性，程序无法精确控制垃圾回收机制执行。

可以将对象的引用变量设置为null，暗示垃圾回收机制可以回收该对象。

程序员可以通过System.gc()或者Runtime.getRuntime().gc()来通知系统进行垃圾回收，会有
一些效果，但是系统是否进行垃圾回收依然不确定。

垃圾回收机制回收任何对象之前，总会先调用它的finalize方法（如果覆盖该方法，让一
个新的引用变量重新引用该对象，则会重新激活对象）。

永远不要主动调用某个对象的finalize方法，应该交给垃圾回收机制调用。