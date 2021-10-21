package collection_concepts.user_defined_classes_with_collections;

class Employee implements Comparable<Employee>{
    String name;
    String id;
    public  Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        //sort Employee on basis of name(ascending order)
       // return this.name.compareTo(otherEmployee.name);
        return this.id.compareTo(otherEmployee.id);
    }

    // toString() method overrides Object class’s toString() method.
    // toString() method is used to give a string representation of an object.
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id  + '}';
    }
}

