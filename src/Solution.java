public class Solution {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor to initialize the queue
    public Solution(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        currentSize++;
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a sentinel value indicating failure
        }
        int dequeuedItem = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return dequeuedItem;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method to get the size of the queue
    public int size() {
        return currentSize;
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int count = 0;
        int index = front;
        while (count < currentSize) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution queue = new Solution(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.display(); // Should print: 1 2 3 4 5
        queue.dequeue(); // Remove an element
        queue.dequeue(); // Remove an element
        queue.display(); // Should print: 3 4 5
        queue.enqueue(6); // Add an element
        queue.display(); // Should print: 3 4 5 6
    }
}