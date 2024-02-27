package basicprogramsforinterview.stackLearninig;

public class StackMain {

    public static void main(String[] args) {

        Stack stack = new Stack(5);
        /*
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(5);
        stack.push(3);
        System.out.println("Before " + stack.toString());

        stack.pop();
        System.out.println("after " + stack.toString());
        */

        /*
               Synchronize learning- starts
         */
        System.out.println("Main thread start");
        new Thread(()->{
            for(int i=0; i<10 ; i++){
                stack.push(100);
                System.out.println(stack.toString());
            }
        }, "pushThread").start();

        new Thread(()->{
            for(int i=0; i<10 ; i++){
                stack.pop();
                System.out.println(stack.toString());
            }
        }, "popThread").start();

    }
}
