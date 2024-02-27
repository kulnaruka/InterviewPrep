package basicprogramsforinterview.learnmultithreading;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<4; i++){
            System.out.println("Thread running is: " + Thread.currentThread().getName() + " " + i);
        }
    }
}
