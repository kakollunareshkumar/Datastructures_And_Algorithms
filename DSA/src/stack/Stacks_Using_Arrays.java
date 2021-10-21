package stack;

import java.util.Scanner;

//push() --> To insert an element  to the stack
//pop() --> To delete an element from the stack
//peek() --> to return the last element from the stack with out deleting the element
public class Stacks_Using_Arrays {

      private  int[]  sArray;
      private int top;
      private int size;


      Stacks_Using_Arrays(int size)
      {
          sArray = new int[size];
          top = -1;
          this.size = size;
      }



      public void push(int element){
          if(isFull())
          {
              System.out.println("Stack is full and you cannot insert more elements");
          }
          else{
              top++;
              sArray[top] = element;
              System.out.println("Element is inserted in to stack");
          }

      }

      public int pop()
      {

          if(isEmpty())
          {
              System.out.println("Stack is Empty");
          }
          else
          {
           int   eDeleted = sArray[top];
              sArray[top] =0;
              top--;
              return eDeleted;
          }
            return -1;
      }

      public int  peek(){

          if(isEmpty())
          {
              System.out.println("stack is empty");
          }
          else
          {
              return sArray[top];
          }
          return  -1;
      }

      public  boolean isFull()
      {
          return  top == size-1;
      }


      public void display()
      {
          if(isEmpty())
          {
              System.out.println("Stack is empty");
          }
          else
          {
              System.out.print("[");

            for(int i=top;i>-1;i--)
              System.out.printf("%d\t",sArray[i]);

            System.out.print("]");
              System.out.println("\n");
          }

      }

      public  boolean isEmpty()
      {
          return  top == -1;
      }

      public  int size()
      {
          int size =top;
          return ++size;
      }
    public static void main(String[] args) {
          int choice;

        Scanner  sc= new Scanner(System.in);

        Stacks_Using_Arrays stack  = new Stacks_Using_Arrays(10);

        while(true)    //untill user exits from display menu I need to repeatedly show the menu to the user
        {
            System.out.println("Please select an operation to perform on stack");
            System.out.printf("1.push() \n2.pop() \n3.peek() \n4.display \n5.size \n6.Exit \n");
            System.out.println("Enter your choice");
            choice  = sc.nextInt();

            switch (choice){

                case 1:
                    System.out.println("Enter an element to insert in to stack");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Removing an element from the stack "+stack.pop());
                    break;
                case 3:
                    System.out.println("Peek or top element of the stack "+stack.peek());
                    break;
                case 4:
                    System.out.println("Display all elements in the stack");
                    stack.display();
                    break;
                case 5:
                    System.out.println("Size of the stack is   "+stack.size());
                    break;
                default:System.exit(0);  //Safe exit
            }

        }
    }

}

//Time complexity
/*

Push Operation : O(1)
Pop Operation : O(1)
Top Operation : O(1)
Search Operation : O(n)
The time complexities for push() and pop() functions are O(1) because we always have to insert
or remove the data from the top of the stack, which is a one step process.

 */

