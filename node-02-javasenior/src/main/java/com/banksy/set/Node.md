```
集合框架
【1】
|----Collection接口：单列集合，用来存储一个一个的对象
    |----List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原有的数组
        |----ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
        |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
        |----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
    |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
        |----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
        |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
                            对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
        |----TreeSet：可以按照添加对象的指定属性，进行排序。
【2】
|----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
    |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
        |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
                            原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
                            对于频繁的遍历操作，此类执行效率高于HashMap。
    |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
                    底层使用红黑树
    |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
    |----Properties:常用来处理配置文件。key和value都是String类型

      HashMap的底层：数组+链表  （jdk7及之前）
                    数组+链表+红黑树 （jdk 8）

【3】
|----Iterator、ListIterator：迭代器
【4】
|----Comparable、Comparator：对象排序接口
【5】
|----Collections：容器工具类
```