package basicprogramsforinterview.learnmultithreading;

import java.sql.SQLOutput;

/**
 * ----> Multitasking <----
 * Multitasking allows several activities to occur concurrently (or at same time) on the computer
 * There are two types :
 *  1. Process based multitasking: For ex. Listening to music in You-tube and writing a code in an IDE
 *      Allows processes (or applications) to run concurrently on the computer.
 *  2. Thread based multitasking: For Ex. in You-tube application you are listening and as well as you are searching
 *      a different video using search bar
 *      So whenever you want to achieve two or more task (multiple functions running) in the same program,
 *      then it can be achieved by thread-based multitasking
 *
 *  ----> Question: What is the difference between THREAD and PROCESS:
 *  --> Answer: -> 1. Two thread operate or share the same address space
 *              -> 2. Switching between two threads is less expensive than switching between the two process
 *              -> 3. Similarly, The cost of communication between two thread is pretty low compare to processes
 *                      as they are sharing same address space
 *
 *  ---> Why we need Multi-threading?
 *  --> In a single-threaded environment, only one task is being performed
 *      Now for ex. While waiting for some user input in a program, the CPU is wasting its time and meanwhile can
 *      perform other tasks
 *      Multitasking allows the idle CPU to put for good use
 *
 *  ----> Thread <----
 *  -> A Thread is an independent sequential path of execution with in a program (In Java there is Main thread which
 *  is prepared by JVM to perform the task of executing the main function)
 *  -> Apart from Main thread, multiple thread can be run concurrently to perform other task in a program
 *  -> At runtime, threads in a program exist in a common memory space and can, therefore, share both data and code
 *  (i.e. They are light weighted compare to Processes)
 *
 *
 * -------------<<<<<<<<<
 *  ---> 3 important concepts related to multithreading in Java <---
 *  -> 1. Creating a threads and providing the code that gets executed by the thread
 *  -> 2. Accessing common data and code through synchronization
 *  -> 3. Transitioning between the thread states
 * >>>>>>>>>>>>---------
 *
 * ----> THE MAIN THREAD
 *  - When a standalone application is run, a user thread is automatically created to execute the main() method of
 *      the application. This thread is called the main thread
 *  - If no other user threads are spawned, the program terminates when main() method finishing the execution
 *  - All the other threads are called CHILD THREADS, which are spawned from the main thread
 *  - The main method can then finish, but the program will keep on running until all the child threads have completed
 *      their execution
 *  - The Runtime environment distinguishes between the user threads and the daemon threads
 *      DAEMON THREAD: Daemon thread in Java is a low-priority thread that performs background operations
 *      such as garbage collection, finalizer, Action Listeners, Signal dispatches, etc.
 *      Daemon thread in Java is also a service provider thread that helps the user thread.
 *  - The execution shutdown time of a program is totally dependent on the user threads only. So, even if
 *      there are any daemon thread's task is running but all the user threads tasks are completed, then, the program
 *      will terminate
 *
 *   - Calling the setDaemon(boolean) method in the Thread class marks the status of the thread as either Daemon or user thread,
 *      But this must be done before the thread has started
 *   - As long as the user thread is alive, the JVM won't terminate
 *   - A daemon thread is at the mercy of the runtime systems, it is stopped as soon as all the user threads are completed, thus terminating the program
 *
 *   ---> Creating a Thread other than the inbuilt Main thread <------
 *   - A thread is represented by an object of the Thread Class
 *   - Creating a thread is achieved by 2 ways :
 *   1. Implementing a thread by using java.lang.Runnable interface
 *   2. Extending the java.lang.Thread class
 *
 *  ---> 1. IMPLEMENTING A RUNNABLE INTERFACE <----
 *          Check Class Thread2, Thread3 objects
 *
 *  ---> 1.Extending the java.lang.Thread class <----
 *            Check Class Thread1
 *
 *  --------------> SYNCHRONIZATION <---------------
 *  - The Threads share the same memory space i.e. they can also share the same resources (objects)
 *  - However, there can be a time or a critical situation, where it is desirable that a resource is accessible to a single thread
 *      For Ex. Cinema Hall ticket ...Where only seat is remaining an two threads, or more, are trying to access the same seat
 *      So, In this case multiple threads are trying to complete the task of booking the single remaining seat.
 *      This situation will create a "RACE CONDITION"  <--- This is not desirable
 *
 *      Coding example is given in the Stack.class ... where we are doing push() and pop() on same array using 2 threads and there comes a situation
 *      where we receive ArrayOutOFBound Exception
 *
 *     --------------> LOCK <---------------
 *     Lock can be any object or can be 'object' of any non-primitive class.
 *
 *     Suppose you need only one thread to access any set of operation. In that case you can create a lock and
 *     once a thread has performed the sets of operation, the thread will pass this lock to JVM and then JVM with the help of
 *     internal scheduler pass the lock to other thread which want to perform the same set of operation.
 *     Ex. in the Stack package, where we are synchronizing with the help of the lock prepared(manual lock) or lock prepared out of same Object/Class
 *
 *     In short,
 *     -> SYNCHRONIZED METHOD:
 *          - While a thread inside a synchronized method of an object, all other threads that wishes to execute this synchronized method or any other synchronized
 *          method of the object will to wait.
 *          - This restriction will not apply to the thread who is already having the lock any is executing the synchronized method of the object
 *          - such a method can invoke any other synchronized method of the object without being blocked, as it has the lock(Make sure there is single lock only)
 *          - The other non-synchronized methods of the object can always be called at any time by any thread
 *
 *    -> RULES OF SYNCHRONIZATION:
 *          - A thread must acquire the lock associated with a shared resource before it can enter a shared resource
 *          - The runtime system or JVM will make sure that no other thread can enter a shared resource,
 *            if there is any thread holds the object lock associated with it
 *          - If a thread cannot immediately acquire the object lock, it is blocked, i.e. it must wait for the object lock to be available
 *          - When a thread exits the shared resource, The runtime system, or JVM, must ensure that the object lock is relinquished (lock is given away by the thread),
 *            also, if another thread is waiting for this object lock, it can try to acquire the lock in order to acquire the access to the shared resource
 *          - It should be made clear that program should not make any assumptions of the order to give the access to the object lock to the threads
 *          - STATIC SYNCHRONIZED METHOD:
 *             - A thread acquiring the lock of a class to execute a static synchronized method has no effect on the the thread acquiring the lock of any object
 *               of the class to execute a synchronized instance method
 *               (IMP****) This is because the object lock for the static method(MyClassName.class object)
 *               is different from the lock of a synchronized non-static method(this object)
 *            - In other words, the synchronization of the static methods is independent for the synchronization of the
 *              instance of methods of the object of the class
 *            - A sub-class decides whether the new definition of an inherited synchronized method will remain synchronized in the subclass
 *
 *      -> RACE CONDITION:  It occurs when two or more threads simultaneously update the same value (stackTop index value in our stack example) and,
 *          as a consequence, leave the value in an undefined or inconsistent state.
 *
 *      -> SYNCHRONIZED BLOCKS:
 *          - Whereas execution of synchronized methods of an object is synchronized on the lock f the object,
 *            the synchronized block allows execution of arbitrary code to be synchronized on the lock of an
 *            arbitrary object
 *          - The general form of the synchronized statement is as follows
 *              synchronized(Object ref expression){
 *                  <code block>
 *              }
 *          - The object ref expression much be evaluate to a non-null reference value, otherwise a
 *          NullPointerException is thrown
 *
 *        -> SUMMARY:
 *          A thread can hold a lock on an object:
 *          1. By executing a synchronized instance method of the object (this)
 *          2. By executing the body of a synchronized block that synchronizes on the object (this)
 *          3. By executing a synchronized static method of a cass or a block inside a static method (in which case,
 *          the object in the Class object representing the class in the JVM)
 *
 *        -> THREAD SAFETY:
 *        it is a term used to describe the design of the classes that ensure that the state of their objects is always,
 *        consistent, even when the objects are used concurrently by multiple threads. Eg: StringBuffer, StingBuilder is Not
 *
 *
 *        -> THE VOLATILE KEYWORD:
 *        In Java, the volatile keyword is used to indicate that a variable's value may be modified
 *        by multiple threads that are executing concurrently.
 *        When a variable is declared with the volatile keyword, it ensures that any thread reading the variable
 *        will see the most recent write to that variable by any other thread.
 *
 *        -> Here are some key points about volatile:
 *              1. Visibility: When a variable is declared as volatile, changes made by one thread to the
 *                variable are immediately visible to other threads.
 *                This ensures that changes are not held locally in a thread's cache, but are always visible
 *                to other threads.
 *
 *             2. No Atomicity: While volatile ensures visibility, it does not guarantee atomicity for compound
 *               actions (such as incrementing a variable). For compound actions, you typically need to
 *               use synchronization mechanisms like synchronized blocks or classes from the
 *               java.util.concurrent.atomic package.
 *
 *             3. Use Cases: volatile is commonly used for flags and status variables that are shared among
 *                threads but do not involve compound actions.
 *                For example, a-> while creating Singleton Class(only a single object can be created of that class)
 *                b-> an boolean flag indicating whether a thread should stop its execution can be declared as volatile.
 *
 *              Here's an example of using volatile keyword:
 *              *********************
 *              public class SharedResource {
 *                  private volatile boolean stopRequested = false;
 *
 *                  public void requestStop() {
 *                      stopRequested = true;
 *                  }
 *
 *                  public boolean isStopRequested() {
 *                      return stopRequested;
 *                   }
 *              }
 *
 *              *********************
 *              In this example, the stopRequested flag is declared as volatile to ensure that changes made by
 *              one thread to this flag are immediately visible to other threads.
 *              This is important if multiple threads are accessing the isStopRequested() method concurrently
 *              to check whether the stop is requested.
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class MultithreadingExample {
    public static void main(String[] args) {


        //Thread thread1 = new Thread1("myThreadName1");
        /*
            The First way of creating a Thread through extending a Thread CLass is NOT Recommended as once you extend your class
            you can't implement or extend any other implementations or no inheritance property to avail for you class
        */

        //To make any as the daemon thread
        //thread1.setDaemon(true);
        //thread1.start();

        Thread thread2 = new Thread(new Thread2(), "MyThreadName2");
        /*
                        OR
        Thread thread2 = new Thread(new Thread2());
        */

        Thread thread3 = new Thread(()->{
            System.out.println("I am thread 3 and I am Created by Lambda EXP" +
                    " ...my method name is run() ");
        });

        thread2.start();
        thread3.start();
        System.out.println("Main thread is running");
        System.out.println("Main thread has ended");
        //NOTE: The output sequence is totally depends on the mercy of JVM.
    }

}




















