package basicprogramsforinterview.designpattern.singletonDesignPatternTVSet;


/**
 * A Singleton class in Java is a class that ensures that only one instance of itself can exist and provides
 * a global point of access to that instance. It's commonly used when you need to control object creation,
 * limit the number of instances to one, and provide global access to that instance.
 *
 * Here's a basic implementation of a Singleton class in Java:
 * ------------------
 public class Singleton {
 // Private static variable to hold the single instance of the class
 private static Singleton instance;

 // Private constructor to prevent instantiation from outside
 private Singleton() {
 // Optional: Initialize the singleton instance here
 }

 // Public static method to provide access to the singleton instance
 public static Singleton getInstance() {
 // Lazy initialization: Create the instance if it doesn't exist yet
 if (instance == null) {
 instance = new Singleton();
 }
 return instance;
 }

 // Other methods and variables can be added as needed
 }
 * ------------------
 * In this implementation:
 *
 * The class Singleton has a private static variable instance to hold the single instance of the class.
 * The constructor is private to prevent instantiation of the class from outside.
 * The getInstance() method provides global access to the singleton instance.
 * It lazily initializes the instance if it hasn't been created yet.
 * Other methods and variables can be added to the class as needed.
 * It's important to note that while this implementation works in most cases, it's not thread-safe.
 * If multiple threads attempt to access getInstance() simultaneously, it's possible to create multiple instances
 * of the singleton. To make the Singleton class thread-safe, you can use synchronization or rely
 * on the initialization-on-demand holder idiom or use an enum.
 *
 *
 * ----- USE of Singleton design pattern:
 *
 * The Singleton pattern is used in scenarios where you need to ensure that a class has only one instance and
 * provide a global point of access to that instance. Here are some common use cases for the Singleton pattern:
 *
 * -> Logging: When you want to create a logging system that logs messages from various parts of your application,
 * you might use a Singleton logger to ensure that all messages are logged to the same file or console.
 *
 * -> Database Connections: In applications that require database access, you might use a Singleton database connection
 * to ensure that multiple parts of your application share the same connection to the database,
 * rather than opening and closing multiple connections.
 *
 * -> Configuration Management: When you have configuration settings that need to be accessed throughout
 * your application, such as application settings, you can use a Singleton configuration manager to provide
 * access to these settings from anywhere in your code.
 *
 * -> Caching: Singletons are often used to implement caching mechanisms. For example,
 * if you have an object cache that needs to be shared across different parts of your application,
 * you might use a Singleton cache manager to manage the caching logic.
 *
 * -> Thread Pools: In multithreaded applications, you might use a Singleton thread pool to
 * manage a pool of worker threads that can be used to execute tasks concurrently.
 *
 * -> Resource Managers: Singletons are useful for managing limited resources such as connections
 * to external systems, hardware devices, or expensive objects.
 *
 * In summary, the Singleton pattern is used to ensure that there's only one instance of a class and to provide
 * a global point of access to that instance, making it useful for managing resources, configurations,
 * and shared state in applications.
 * However, it's important to use the Singleton pattern judiciously and consider potential drawbacks such as
 * tight coupling and difficulties with unit testing.
 *
 */
public class TVSet {

    static volatile TVSet tvSetInstance = null;
    String name;

    //Step 1. Use access modifier as 'private' in order to prevent the creation of multiple object
    private TVSet(String name){
        this.name = name;
        System.out.println("TV set instanced");
    }

    //Step 2. Now, in order to return the only object we are creating below method
    //Step 3. In order the main/client to use this class for object creation we need to make the below method static
    public static TVSet getTVSetObject(String name){
        if(tvSetInstance==null){
            synchronized (TVSet.class){
                //if both t1 and t2 came
                //This is for double-checking
                if(tvSetInstance==null)
                tvSetInstance = new TVSet(name);
            }
        }
        return tvSetInstance;
    }

    @Override
    public String toString() {
        return "TVSet{" +
                "name='" + name + '\'' +
                '}';
    }
}

















