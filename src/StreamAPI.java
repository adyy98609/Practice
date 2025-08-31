import model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        List<Person> person = new ArrayList<>();
        person.add(new Person("Alice",12,"Male"));
        person.add(new Person("Aditya",12,"Male"));
        person.add(new Person("Ayushi",14,"Female"));
        person.add(new Person("Akash",15,"Male"));
        Map<Integer, Map<String, List<String>>> grouped =
                person.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.groupingBy(Person::getGender,Collectors.mapping(Person::getName,Collectors.toList()))
                        ));
        System.out.println(grouped);

        Optional<String> name = person.stream().filter(e->e.getAge()>12).map(Person::getName).findFirst();
        System.out.println(name);

        Map<Integer,Integer> ageMap = person.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.summingInt(Person::getAge )));
        System.out.println(ageMap);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int result = numbers.stream().filter(num-> num%2==0).map(num-> num*num).reduce(0,Integer::sum);
        System.out.println(result);

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean,List<Integer>> map = numberList.stream().collect(Collectors.partitioningBy(e-> e%2==0));
        System.out.println(map);

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream2 = Stream.of(3, 4, 5, 6);

        List<Integer> mergedList = Stream.concat(stream1,stream2).distinct().sorted((e1,e2)->e2-e1).toList();
        System.out.println(mergedList);

        List<Integer> newNumber = Arrays.asList(10, 20, 40, 45, 99, 5);
        int thirdLargest = newNumber.stream().sorted((n1,n2)->n2-n1).skip(2).findFirst().orElse(-1);
        System.out.println(thirdLargest);

        List<String> words = Arrays.asList("Java", "Stream", "API");
        String combined = String.join(",", words);
        System.out.println(combined);

        List<Integer> ansList = Arrays.asList(10, 60, 30, 90, 15, 75, 25);

        int firstElementGreaterThan50 = ansList.stream().filter(e->e>50).findFirst().orElse(-1);
        System.out.println(firstElementGreaterThan50);
        int lastElementLessThan30 = ansList.stream().filter(e->e<30).reduce((first,second)->second).orElse(-1);
        System.out.println(lastElementLessThan30);

        List<Integer> createMap = Arrays.asList(1, 2, 3, 4);
        Map<Integer,Integer> mapOfCombo = createMap.stream().collect(Collectors.toMap(e->e,e->e*e));
        System.out.println(mapOfCombo);

        List<Integer> mostFrequentNumber = Arrays.asList(1, 2, 3, 3, 3, 4, 5, 6);
        int mostFrequent = mostFrequentNumber.stream().collect(Collectors.groupingBy(e->e,Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println(mostFrequent);

        //sort person list by age and then name
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge).reversed().thenComparing(Person::getName);
        List<Person> sortedPersonList = person.stream().sorted(byAgeComparator).toList();
        System.out.println(sortedPersonList);

        //find max and min age
        Optional<Integer> maxAgeOfPerson = person.stream().max(Comparator.comparingInt(Person::getAge)).map(Person::getAge);
        System.out.println(maxAgeOfPerson);

        Optional<Integer> minAgeOfPerson = person.stream().min(Comparator.comparingInt(Person::getAge)).map(Person::getAge);
        System.out.println(minAgeOfPerson);
    }
}
