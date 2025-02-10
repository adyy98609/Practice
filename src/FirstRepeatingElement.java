import java.util.*;

public class FirstRepeatingElement {

    private static int getFirstRepeatingElement(int[] array){
        List<Integer> list = Arrays.stream(array).boxed().toList();
        Map<Integer,Integer> map = new LinkedHashMap<>();
        list.forEach(e->{
            map.put(e, Collections.frequency(list,e));
        });
        Set<Integer> set = new LinkedHashSet<>();
        map.forEach((k,v)->{
            if(v == 2){
                set.add(k);
            }
        });
        return !set.stream().toList().isEmpty() ? set.stream().toList().getFirst(): -1;
    }

    public static void main(String[] args) {
       int[] arr = {10, 5, 3, 4, 3, 5, 6};
       int result = getFirstRepeatingElement(arr);
       System.out.println(result);
    }
}
