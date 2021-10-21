package collection_concepts;

import java.util.*;

public class Array_List {
    public static void main(String[] args) {
        //Always create objects for interfaces and not for child classes  //Naresh
        //Always code to interfaces never to child classes  //Book version
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(10);  //0
        al.add(10);  //1
        al.add(20);  //2
        al.add(20);  //3
        al.add(30);  //4
        al.add(40);  //5
        System.out.println("Element at index position 2 "+al.get(2));
        //Now instead of printing  all elements at once I want to iterate one element by one element
        //This is possible by using iterators in collections.
        //Now I got a doubt we already have while and for loops to iterate elements then why we need to go for
        //Iterator concepts like Enumeration, Iterator and List Iterator

        // for and while loops will not work with set concept in collection
        //Enumeration  -->this iterator only works with legacy collections -->vector and stack which is introduced in JDK 1.0 version
        //Iterator --->This is a univesal cursor and can be used with list and set interfaces.
        //List Iterator --> This iterator will be used only for list interaface collections.
        //? how do I iterate map elements. Ans) As map is not a part of collection interface iterator is not available for map interface
        //Is there is a solution to iterate map elements too?  Ans) Yes we need to convert map to set collection and can iterate keys and values

        //Iterate array list elements

        Iterator<Integer> itr = al.iterator();   //For interfaces we cannot create objects if we want to create object for interfaces
        //use child class objects
        while(itr.hasNext())
        {

            System.out.println(itr.next());
        }

        //Array is index based structure

        //Set does not allow duplicates and  set is unordered means we don't know in which order elements are inserted each time
        Set<Integer> set = new HashSet(al);
        set.add(-1);
        set.add(50);
        set.add(100);
        set.add(500);
        System.out.println("Hashset elements");
        Iterator<Integer> itr1  = set.iterator();

        while (itr1.hasNext())
        {
            System.out.println(itr1.next());
        }

        //Map keys should be always unique but values can be duplicate. Map is unordered collection
        Map<Integer,String> map = new HashMap();
        map.put(1,"naresh");   //1 key and 1 value is called an entry

        map.put(2,"suresh");

        System.out.println("Map keys and values "+map);

        //As map interface does not have iterator support we need to convert hashmap to set and set is having support for interator
        // We can iterate all the keys and vales in hashmap
        Set<Map.Entry<Integer,String>> set1 = map.entrySet();

        Iterator<Map.Entry<Integer,String>> iterator1 = set1.iterator();

        while (iterator1.hasNext())
        {
            Map.Entry<Integer,String> entry = iterator1.next();
            System.out.println("key = "+entry.getKey()+ " "+"value = "+entry.getValue());
        }

        //Keyset and values

        //suppose you want to retrieve only keys from hashmap   1st case
        //Suppose you need to retrieve only values from hashmap  2nd case

        System.out.println("1st case to retrieve only keys from hashmap");
        Set<Integer> set2 =  map.keySet();
        Iterator iterator3  = set2.iterator();
        while (iterator3.hasNext())
        {

            System.out.println(iterator3.next());
        }


        System.out.println("2st case to retrieve only values from hashmap");
        Collection<String> c = map.values();
        Iterator<String> iterator4 = c.iterator();
        while (iterator4.hasNext())
        {

            System.out.println(iterator4.next());
        }

        //List iterator the drawback of this is it can be applied to only list interface classes
        ListIterator<Integer> li = al.listIterator();
        while(li.hasNext())
        {
            System.out.println(li.next());
        }

        //Enumeration iterator the drawback of this iterator is it is only applicable to only legacy classes i.e  vector and stack
        System.out.println("Enumeration elements of a vector class ");
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);


        Enumeration<Integer> e = v.elements();

        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }
}
