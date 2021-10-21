package collection_concepts.user_defined_classes_with_collections;

import java.util.LinkedList;

public class Address_Main {
        public static void main(String args[]) {
            LinkedList<Address> ml = new LinkedList<Address>();

            // Add elements to the linked list.
            ml.add(new Address("CSS", "11 Main Ave",
                    "New York", "IL", "12345"));
            ml.add(new Address("HTML", "1234 Main Lane",
                    "New London", "IL", "23456"));
            ml.add(new Address("Java", "123 Main St",
                    "New City", "IL", "98765"));

            // Display the mailing list.
            for(Address element : ml)
                System.out.println(element + "\n");

            System.out.println();






        }
    }

