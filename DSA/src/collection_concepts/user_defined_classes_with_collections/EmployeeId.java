package collection_concepts.user_defined_classes_with_collections;

import java.util.Comparator;

public class EmployeeId implements Comparator<Employee> {

    @Override
        public int compare(Employee obj1, Employee obj2) {
            //sort Employee on basis of id(ascending order)
            return obj1.id.compareTo(obj2.id);
        }
}
