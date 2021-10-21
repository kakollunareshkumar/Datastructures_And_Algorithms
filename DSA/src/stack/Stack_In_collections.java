package stack;


import java.util.Stack;

public class Stack_In_collections{

    public static void main(String[] args) {

        Student s1  = new Student(1,"naresh","AP");
        Student  s2 = new Student(2, "suresh","TS");
        Student  s3 = new Student(3,"harsha","KA");

        Stack<Student> stack = new Stack<>();
        stack.push(s1);
        stack.push(s2);
        stack.push(s3);
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

       // Student s4 = stack.peek();
        System.out.println(stack.peek());

    }

}
class  Student{


    private  int rollNO;
    private String name;
    private String address;

    public Student(int rollNO, String name, String address) {
        this.rollNO = rollNO;
        this.name = name;
        this.address = address;
    }


    public int getRollNO() {
        return rollNO;
    }

    public void setRollNO(int rollNO) {
        this.rollNO = rollNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Student{" +
                "rollNO=" + rollNO +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
