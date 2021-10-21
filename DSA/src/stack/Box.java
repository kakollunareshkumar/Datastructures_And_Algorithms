package stack;


public class Box {
    private int t;

    public void add(int t) {
        this.t = t;
    }

    public int get() {
        return t;
    }

    public static void main(String[] args) {
        Box integerBox = new Box();

        integerBox.add(new Integer(10));

        System.out.printf("Integer Value :%d\n\n", integerBox.get());
    }
}
