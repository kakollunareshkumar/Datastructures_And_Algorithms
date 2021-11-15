package collection_concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_Test {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        Iterator<Integer> itr = al.listIterator();

        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
}
