// Example:
// Input: Stream of "zin", "tin", "adam", "john", "jerry", "tom"
// Output: {a=[adam], j=[john, jerry], t=[tin, tom], z=[zin]}

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    private static void getNamesListByLetter(List<String> names){
       Map<String,List<String>> namesMap = new LinkedHashMap<>();
       List<String> firstLetter = names.stream().map(e->String.valueOf(e.charAt(0))).distinct().sorted().toList();
        System.out.println(firstLetter);
        firstLetter.forEach(e->{
           namesMap.put(e, names.stream().filter(i->i.startsWith(e)).collect(Collectors.toList()));
       });
        System.out.println(namesMap);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("zin");
        names.add("tin");
        names.add("adam");
        names.add("john");
        names.add("jerry");
        names.add("tom");
        getNamesListByLetter(names);

        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(1);
        integers.add(3);
        Integer sum = integers.stream().filter(e -> e % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
