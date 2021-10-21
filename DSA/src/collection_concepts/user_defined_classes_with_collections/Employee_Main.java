package collection_concepts.user_defined_classes_with_collections;

import collection_concepts.Array_List;

import java.util.ArrayList;
import java.util.Collections;

public class Employee_Main {
    public static void main(String[] args) {

        Employee emp1=new Employee("sam","4");
        Employee emp2=new Employee("amy","2");
        Employee emp3=new Employee("brad","1");

        ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("list Before sorting : \n"+list);

        Collections.sort(list);

        System.out.println("\nlist after sorting on basis of name(ascending order) : \n"+list);



        }
    }

