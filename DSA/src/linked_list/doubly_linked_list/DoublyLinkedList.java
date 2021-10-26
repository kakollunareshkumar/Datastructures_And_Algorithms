package linked_list.doubly_linked_list;

class Node
{
    int data;
    Node prev;
    Node next;

    public Node()
    {

    }
    public Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}



public class DoublyLinkedList {
    Node head;
    Node tail;
    int count = 0;



    void insertionAtBegining(int data){
        Node newNode  = new Node(data);

        if(head == null){

            head = newNode;
        }

        newNode.next = head.next;
        newNode.prev = null;
        head = newNode;
        count++;
        System.out.println("Element inserted at begining successfully");
    }
    void insertionAtEnd(int data){

        Node newNode  = new Node(data);
        Node temp = head;
        newNode.next = null;

        if(head == null)
        {
            newNode.prev =null;
            head = newNode;
            return;
        }

        while(temp.next!= null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev=temp;
        count++;
        System.out.println("Node inserted at begining successfully");

    }

    void insertAfterSpecificPosition(int data, int position){

        Node newNode  = new Node(data);
        if(head==null)
        {
            System.out.println("The linked list is empty");
            return;
        }
        Node temp=head;
        int pos = position;
        int i=1;
        while (i<pos-1)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev =head;
        newNode.next = null;
        count++;
        System.out.println("Node inserted after specific position");
    }

    void deletionAtBegining(){
        Node temp;
        if(head==null)
        {
            System.out.println("The linked list is empty");
            return;
        }
        temp = head;
        if(head.next!=null)
        {
            head =head.next;
        }
        temp.prev = null;
        temp.next = null;
        temp = null;
        count--;
        System.out.println("Node deleted at begining successfully");
    }

    void delationAtEnd(){
        Node temp;
        Node tail;
        if(head==null)
        {
            System.out.println("The linked list is empty");
            return;
        }
        temp = head;
        tail =head;
        while (temp.next!=null)
        {
            temp=temp.next;
            tail=temp;
        }

        temp = temp.prev;
        tail = tail.prev;
        temp.prev = null;
        temp.next = null;
        temp = null;
        count--;
        System.out.println("Node deleted successfully at end");
    }

    void  deletionAtSpecificPosition(int position){

        Node temp;
        if(head==null)
        {
            System.out.println("The linked list is empty");
            return;
        }
        temp = head;
        int i=1;
        int pos =position;

        if(pos<count) {

            while (i < pos) {
                temp = temp.next;
                i++;
            }
            temp.prev.next = temp.next;
            temp.next.prev= temp.prev;
            temp.prev = null;
            temp.next = null;
            temp= null;
            System.out.println("Node deleted successfully at specified position");
        }
        else {
            System.out.println("Node doesn't exists at specified  position deletion not possible");
        }

    }

    void displayElements(){
        if(head ==null)
        {
            System.out.println("The linked list is empty");
            return;
        }
        Node temp = head;
        System.out.println("Traversal of Linked List");

        while(temp!=null)
        {
            if(temp.next ==null)
            {
                System.out.println(temp.data);
                return;
            }
            else {
                System.out.print(temp.data+"--->");
                temp = temp.next;
            }
        }

    }

    public static void main(String[] args) {

        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insertionAtBegining(11);
        dl.displayElements();
        dl.insertAfterSpecificPosition(12,2);
        dl.displayElements();
        dl.insertionAtEnd(13);
        dl.displayElements();
        dl.deletionAtBegining();
        dl.displayElements();
        dl.delationAtEnd();
        dl.displayElements();
        dl.deletionAtSpecificPosition(2);
        dl.displayElements();

    }

}

















