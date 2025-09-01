package immutable;

import java.util.Arrays;
import java.util.List;

public record ImmutableCollectionRecord(String name, int age, List<String> hobbies) {

    public ImmutableCollectionRecord{
        if(name == null || age == 0 || hobbies ==null){
            throw new IllegalArgumentException("Name, Age and Hobbies cannot be null");
        }
        hobbies = List.copyOf(hobbies);
    }

    public static void main(String[] args) {
        List<String> hobbies = Arrays.asList("Reading","Traveling");
        ImmutableCollectionRecord person = new ImmutableCollectionRecord("John",30,hobbies);
        System.out.println(person);
        // Attempt to modify the list outside
        try {
            person.hobbies.add("AWS");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification not allowed! Immutable class is safe.");
        }
        System.out.println(person);

        System.out.println("Original list: " + hobbies);
        System.out.println("Person's skills: " + person.hobbies());
    }
}
