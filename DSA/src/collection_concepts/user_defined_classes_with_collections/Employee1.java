package collection_concepts.user_defined_classes_with_collections;

public class Employee1 {
    String name;
    String id;

    public Employee1() {}

    public Employee1(String name, String id) {
        this.name = name;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id  + '}';
    }
}
