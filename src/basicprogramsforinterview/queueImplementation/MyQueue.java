package basicprogramsforinterview.queueImplementation;

import java.util.Arrays;

public class MyQueue {

    private int capacity;
    private int rear = -1 ;
    private int front = 0;
    private int currentSize = 0;
    private int[] queue;


    MyQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
    }

    boolean pushing(int element){
        if(currentSize==capacity){
            System.out.println("QUEUE IS FULL");
            return false;
        } else{
            rear++;
            queue[rear] = element;
            currentSize++;
            return true;
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "currentSize=" + currentSize +
                ", queue=" + Arrays.toString(queue) +
                '}';
    }

    int popping(){
        if(rear<0){
            System.out.println("QUEUE IS EMPTY");
            return -1;
        } else{
            int returnVal = queue[front];

            for(int i=0; i<currentSize-1; i++){
                queue[i] = queue[i+1];
            }
            queue[rear] = 0;
            rear--;
            currentSize--;
            return returnVal;
        }

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.pushing(5);
        queue.pushing(6);
        queue.pushing(2);
        queue.pushing(31);
        System.out.println("1" + queue.toString());
        queue.pushing(34);
        queue.pushing(10);
        System.out.println("2" + queue.toString());
        queue.popping();
        System.out.println("3" + queue.toString());
        queue.popping();
        System.out.println("4" + queue.toString());
        queue.popping();
        System.out.println("5" + queue.toString());
        queue.popping();
        System.out.println("6" + queue.toString());
        queue.popping();
        System.out.println("7" + queue.toString());
        queue.popping();
        System.out.println("8" + queue.toString());


    }
}
