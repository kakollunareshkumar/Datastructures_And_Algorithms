package stacks_queues_using_arrays_code;

import java.util.Scanner;

import static java.lang.System.exit;

public class Queues_Using_Arrays {
    int queueArr[];
    int front;
    int rear;
    int Size = 0;
    int sizeOfQueue;

    public Queues_Using_Arrays(int sizeOfQueue) {
        front = -1;
        rear = -1;
        this.sizeOfQueue = sizeOfQueue;
        queueArr = new int[sizeOfQueue];
    }

    /**
     * this method is used to add element in the queue
     *
     * @param element
     */
    public void enqueue(int element) {
        if(rear == sizeOfQueue-1)
            System.out.println("\nQueue is Full!!! Insertion is not possible!!!");
        else{
            if(front == -1)
                front = 0;
            rear++;
            Size++;
            queueArr[rear] = element;
            System.out.println("\nInsertion success!!!");
        }
    }

    /**
     * This method removes an element from the front of the queue
     */
    public void dequeue() {
        if(front == rear&&rear!=0)
            System.out.println("\nQueue is Empty!!! Deletion is not possible!!!");
        else{
            System.out.printf("\nDeleted : %d", queueArr[front]);
            queueArr[front]=0;
            front++;
            Size--;
            if(front == rear)
                front = rear = -1;
        }
    }

    /**
     * This method is use to check if element is full or not
     *
     * @return boolean
     */
    public boolean isFull() {
        if (Size == sizeOfQueue-1) {
            return true;
        }
        return false;
    }

    /**
     * This method is use to check if element is empty or not
     *
     * @return
     */
    public boolean isEmpty() {

        if (Size == 0) {
            return true;
        }
        return false;
    }

    int size()
    {
        return Size;
    }

    int peek()
    {
        return  queueArr[front];
    }

    void display() {
        if (rear == -1)
            System.out.println("\nQueue is Empty!!!");
        else {
            int i;
            System.out.println("\nQueue elements are:\n");
            for (i = front; i <= rear; i++)
                System.out.printf("%d\t", queueArr[i]);
        }
    }



    public static void main(String args[]) {

        Queues_Using_Arrays queue = new Queues_Using_Arrays(5);
        int value, choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n***** MENU *****\n");
            System.out.println("1. Insertion\n2. Deletion\n3. Display\n4.Size\n5.Peek\n6.Exit");
            System.out.println("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the value to be insert: ");
                    value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println(" Size of elements "+queue.size());
                    break;
                case 5:
                    System.out.println(" Peek element of the queue "+queue.peek());
                    break;
                case 6:
                    exit(0);
                default:
                    System.out.println("\nWrong selection!!! Try again!!!");
            }
        }
    }
}

/*

Time Complexity:
Operations              Complexity
Enque(insertion)           O(1)
Deque(deletion)            O(1)
Front(Get front)           O(1)
Rear(Get Rear)             O(1)
Search                     0(n)
Auxiliary Space: O(N).
N is the size of array for storing elements.
 */