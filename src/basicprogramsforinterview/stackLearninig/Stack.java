package basicprogramsforinterview.stackLearninig;

//LIFO- last in first out


import java.util.Arrays;

public class Stack {

    private int[] stackItems;
    private int stackTop;

    public Stack(int capacity){
        this.stackItems = new int[capacity];
        this.stackTop = -1; //as there are no element
    }

    boolean isEmpty(){
        return this.stackTop<0;
    }

    boolean isFull(){
        return this.stackTop>=stackItems.length-1;
    }

    //Insert an element - >  push
    public void push(int element){
        /*
        1. Way one to synchronize a block of code; in the below example the instance of this current object is
            is used as the lock

            NOTE: in case when a Class is only having static methods only
            the lock prepared by the compiler is MyStaticClass.class
            synchronized (MyStaticClass.class)
        */
        synchronized (this){
            if(this.isFull()){
                System.out.println("STACK IS FULL");
            } else{
                try{
                    //Thread.sleep(1000);
                }catch(Exception e){
                    System.out.println(e);
                }
                ++stackTop;
                this.stackItems[stackTop] = element;
            }
        }

    }

    // Delete an element
    //2. Way two to synchronize the entire method; here the lock will by default has the current object as the lock
    public synchronized void pop(){
        if(this.isEmpty()){
            System.out.println("STACK IS EMPTY");
        } else{
            try{
                //Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
            } //This can be ignored
           this.stackItems[stackTop] = 0;
           stackTop--;
        }
    }


    @Override
    public String toString() {
        return "Stack{" +
                "stackItems=" + Arrays.toString(stackItems) +
                '}';
    }
}
