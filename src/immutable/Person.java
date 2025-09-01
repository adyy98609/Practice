package immutable;

import java.util.Objects;

public final class Person {

    private final String name;
    private final int age;
    private final Address address;

    public Person(String name,int age, Address address){
        this.name = name;
        this.age = age;
        this.address = new Address(address);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    public static void main(String[] args) {
        Address address = new Address("123 main st");
        Person person = new Person("John",30,address);

        System.out.println(person);

        address = new Address("789 diff st");

        System.out.println(person);

        Address extracted = person.getAddress();
        extracted = new Address("Bangalore");
        System.out.println(person);

    }
}


