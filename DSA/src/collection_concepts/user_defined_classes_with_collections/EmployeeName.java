package collection_concepts.user_defined_classes_with_collections;

import java.util.Comparator;

public class EmployeeName implements Comparator<Employee> {
    @Override
    public int compare(Employee obj1, Employee obj2) {
        //sort Employee on basis of name(ascending order)
        return obj1.name.compareTo(obj2.name);
    }
}
