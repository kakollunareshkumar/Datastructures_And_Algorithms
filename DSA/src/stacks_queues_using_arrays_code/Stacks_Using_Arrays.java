package stacks_queues_using_arrays_code;

import java.util.Scanner;

import static java.lang.System.exit;

public class Stacks_Using_Arrays {
    int size;
    int arr[];
    int top;


    Stacks_Using_Arrays(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int pushedElement) {
        if (!isFull()) {
            top++;
            arr[top] = pushedElement;
            System.out.println("Pushed element:" + pushedElement);
        } else {
            System.out.println("Stack is full !");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("Popped element :" + arr[returnedTop]);
            return arr[returnedTop];

        } else {
            System.out.println("Stack is empty !");
            return -1;
        }
    }

    public int peek() {
        if(!this.isEmpty())
            return arr[top];
        else
        {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public int size(){
        int size =top;
        return  ++size;
    }
    public void display() {
        if (top == -1)
            System.out.println("\nStack is Empty!!!");
        else {
            int i;
            System.out.println("\nStack elements are:\n");
            for (i = top; i >= 0; i--)
                System.out.printf("%d\n", arr[i]);
        }
    }

    public static void main(String[] args) {
        Stacks_Using_Arrays StackCustom = new Stacks_Using_Arrays(10);

        int  choice;
        while(true){
            System.out.printf("\n\n***** MENU *****\n");
            System.out.printf("1. Push\n2. Pop\n3. Display \n4.Size  \n5. Exit");
            System.out.printf("\nEnter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch(choice){
                case 1: System.out.printf("Enter the value to be insert: ");
                    choice = sc.nextInt();
                    StackCustom.push(choice);
                    break;
                case 2: StackCustom.pop();
                    break;
                case 3: StackCustom.display();
                    break;
                case 4:
                    System.out.println(StackCustom.size());
                break;
                case 5: exit(0);
                default: System.out.printf("\nWrong selection!!! Try again!!!");
            }
        }


    }
}
