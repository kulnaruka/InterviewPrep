package basicprogramsforinterview.learnmultithreading;

public class Thread1 extends Thread{

    // Naming a thread
    public Thread1(String threadName){
        super(threadName);
    }


    @Override
    public void run() {
        for(int i=0; i<5; i++ ){
            System.out.println("Thread1 thread is running: " + Thread.currentThread().getName() + " " + i);
            //System.out.println("thread running is: " + Thread.currentThread());
            //System.out.println("Thread1 thread is running: " + super.getName() + " " + i);

            /*
                  i/p: Thread.currentThread()
                  o/p: Thread[myThreadName1,5,main]

                  in the output array 1st thing is thread name,
                  2nd is the priority
                  3rd is the parent thread name

             */
        }
    }
}
