package basicprogramsforinterview.learnmultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ExecutorService in Java is a framework provided by the java.util.concurrent package to manage and control
 * asynchronous execution of tasks. It provides a higher-level abstraction for executing tasks concurrently,
 * managing thread pools, and handling task submission and execution.
 *
 * Here are some key points about ExecutorService:
 *
 * -> Task Execution: You can submit tasks to an ExecutorService for execution.
 *      Tasks can be represented as Runnable or Callable objects.
 *
 * -> Thread Pool Management: ExecutorService manages a pool of worker threads, allowing you to control the number
 * of threads used for executing tasks. This helps in avoiding the overhead of thread creation and destruction
 * for each task.
 *
 * -> Asynchronous Execution: Tasks submitted to an ExecutorService are executed asynchronously,
 * allowing the main program to continue executing other tasks without waiting for the completion of submitted tasks.
 *
 * -> Task Completion: ExecutorService provides methods to wait for the completion of submitted tasks,
 * check if tasks have completed, or retrieve the result of completed tasks.
 *
 * -> Lifecycle Management: ExecutorService provides methods to start, shutdown, or terminate the executor service.
 * This ensures proper cleanup of resources associated with the executor service.
 */

class Task implements Callable<List<Integer>> {
    int num;
    Task(int num){
        System.out.println("Task created "+ num);
        this.num = num;
    }
    void runTask(){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<this.num; i++ ){
            list.add(i);
        }
        System.out.println(this.num+" "+list);
        //return list;
    }

    List<Integer> runTaskReturn(){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<this.num; i++ ){
            list.add(i);
        }
        System.out.println(this.num+" "+list);
        return list;
    }

    @Override
    public List<Integer> call() throws Exception {
        return this.runTaskReturn();
    }
}
public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /*executorService.execute(()->new Task(3).runTask());
        executorService.execute(()->new Task(2).runTask());
        executorService.execute(()->new Task(4).runTask());
        executorService.execute(()->new Task(5).runTask());
*/
        // If threads are returning values after their completion, you can use the submit() method of ExecutorService
        // in combination with Future objects(Promise) to retrieve the results of the tasks.

        /*
        In this modified example:

        - We submit a task to the executor using executor.submit(...), and the task returns a List<Integer> result after its completion.
        - The submit() method returns a Future<List<Integer>> object representing the future result of the task.
        - We use the get() method of the Future object to wait for the task to complete and retrieve the result.
        - If the task throws an exception during execution, it will be thrown when calling get(), so we handle it using a try-catch block.
         */

        // Way 1:
        //Future<List<Integer>> returnList = executorService.submit(()->new Task(5).call());

        // Way 2: submit(Callable object) where Callable<T> is a Functional interface just like runnable, there for we can also go with way 3
        Future<List<Integer>> returnList = executorService.submit(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                return new Task(5).runTaskReturn();
            }
        });
        // Way 3:
        Future<List<Integer>> returnList2 = executorService.submit(() -> new Task(5).runTaskReturn());
        List<Integer> list = new ArrayList<>();
        try{
            list = returnList.get();
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("List prepared in main: " + list);
        executorService.shutdown();
        System.out.println("Main completed");
    }
}
