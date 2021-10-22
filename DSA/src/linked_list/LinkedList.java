package linked_list;

import java.util.*;

// we will create a node class first with data members
class Node
{
    int data;
    // node class should be self referential because it has to refer the next node
    Node next;
    //set data value, next node reference through method
    public Node(int d)
    {
        data=d;
        next=null;
    }
}

//Now we will create LinkedList class
class Linkedlist{
    Node head;
    //function to check whether linked list is empty or not
    public boolean isEmpty()
    {
        if(head==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //function for inserting element in the begining
    public void insertionAtBegining(int val)
    {
        if(isEmpty())
        {
            head=new Node(val);

        }
        else{
            Node temp=new Node(val);
            temp.next=head;
            head=temp;
        }
    }
    //function for inserting at end
    public void insertionAtEnd(int val)
    {
        if(isEmpty())
        {
            head=new Node(val);
        }
        else{
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=new Node(val);
        }
    }
    //function for insertion at specified position
    public void insertionAtPos(int val, int pos)
    {
        int count=1;
        Node temp=head;
        while(temp!=null)
        {
            count++;
            if(count==pos)
            {
                Node post = temp.next;
                temp.next = new Node(val);
                temp.next.next = post;
            }
            temp = temp.next;
        }
        if(count < pos)
        {
            System.out.println(count);
            System.out.println("linked list is in underflow to insert at specified position");
        }
    }
    //function to traverse and print entire list
    public void printlist()
    {
        System.out.print("list is ");
        Node temp = head;
        while(temp != null)
        {
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
    }
    //function to delete at first
    public void deleteAtBegining()
    {
        head = head.next;
    }
    // function to delete at specified postion
    public void deleteAtPos(int pos)
    {
        int count = 1;
        Node temp = head;
        while (temp != null)
        {
            count++;
            if(count == pos)
            {
                break;
            }
            temp=temp.next;
        }
        if(count < pos)
        {
            System.out.println("linked list is in underflow condition to delete in the position" +pos);
        }
        temp.next = temp.next.next;
    }
    // function to delete at end
    public void deleteAtEnd()
    {
        Node temp = head;
        while( temp.next.next != null )
        {
            temp = temp.next;
        }
        temp.next = null;
    }
    // function to search for an element in the linked list
    public void search(int val)
    {
        Node temp = head;
        int count = 0;
        int flag = 0;
        while(temp != null)
        {
            count++;
            if(temp.data == val)
            {
                System.out.println( val + " found at pos " + count );
                flag = 1;
            }
            temp = temp.next;
        }
        if(flag == 0)
        {
            System.out.println(val +" not found");
        }
    }
    public static void main(String args[])
    {
        Linkedlist listObj = new Linkedlist();

        System.out.println("adding elements to linked list at begining:");
        listObj.insertionAtBegining(4);
        System.out.println("4 is added in linked list");
        listObj.printlist();
        listObj.insertionAtBegining(5);
        System.out.println("\n5 is added in linked list");
        listObj.printlist();
        listObj.insertionAtBegining(7);
        System.out.println("\n7 is added in linked list");
        listObj.printlist();
        listObj.insertionAtBegining(10);
        System.out.println("\n10 is added in linked list");
        listObj.printlist();
        System.out.println("\n\nadding elements to linked list at end:");
        listObj.insertionAtEnd(6);
        System.out.println("6 is added at the end of linked list");
        listObj.insertionAtEnd(20);
        System.out.println("20 is added at the end of linked list");
        listObj.insertionAtEnd(30);
        System.out.println("30 is added at the end of linked list");
        listObj.printlist();
        listObj.insertionAtPos(8,2);
        System.out.println("\n\n8 is added at the 2nd index of linked list");
        listObj.printlist();
        System.out.println("\n\ndeleted the first element");
        listObj.deleteAtBegining();
        listObj.printlist();
        listObj.deleteAtPos(2);
        System.out.println("\ndeleted the element at pos 2");
        listObj.printlist();
        listObj.deleteAtEnd();
        System.out.println("\ndeleted the element at end");
        listObj.printlist();
        System.out.println("\n\nsearching element 5 in list");
        listObj.search(8);
        System.out.println("\nsearching element 15 in list");
        listObj.search(15);
    }
}