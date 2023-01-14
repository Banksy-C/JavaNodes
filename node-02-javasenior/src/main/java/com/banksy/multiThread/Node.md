多线程

并发 （Concurrency）：
并发是一种机制，即指“同时有多个请求被发起，或另一种意义上说支持同时有多个线程存在”；
支持并发即是要能够包容同时来到的多个请求，或说包容同时存在的多个线程 处理这多个请求的方式可以是并行的，这样就要求硬件需要有多个计算核心
也可以是只有一个计算资源，处理完一个请求再处理第二个 / 在不同请求间不停切换运行，意味着同时可以有许多线程存在，但每一时刻正在跑的线程只有一个

并行 （Parallelism）：
并行是一种处理方式（或可以说是一种架构方式），即指“有多个计算核心，可以在同一时间同时处理多个任务 / 
把一个任务分割成小块，在同一时间同时处理多个部分”

同步（Synchronization）：同步是一种要求，即指“在支持并发的情况下，不同请求之间（线程之间）不能发生数据冲突或资源抢占冲突”
要做好同步，往往需要保证对某个资源的操作是原子性 （Atomic）的。
有时， 同步也指“通过某些机制来限制同时存在的多个线程的执行顺序”这一要求

方式一：Syn_Thread_Runnable
SynThread--继承Thread类【extend Thread;】
SynRunnable--实现Runnable接口【implements Runnable;】
ThreadSafeQuestion--需要考虑如何解决线程安全问题？同步机制：有四种方式。
SynLumpThread--同步代码块Thread
SynLumpRunnable--同步代码块Runnable
SynMethodThread--同步方法Thread
SynMethodRunnable--同步方法Runnable

ThreadMethod--Thread方法

方式二：SynLock【同步锁接口】

方式三：CallableImpl【Callable接口】

方式四：ThreadPool【线程池】


