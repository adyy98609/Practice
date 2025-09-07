import java.util.*;

public class FirstRepeatingElement {

    private static int getFirstRepeatingElement(int[] array){
        List<Integer> list = Arrays.stream(array).boxed().toList();
        Map<Integer,Integer> map = new LinkedHashMap<>();
        list.forEach(e->{
            map.put(e, Collections.frequency(list,e));
        });
        Optional<Map.Entry<Integer,Integer>> firstRepeatingElement = map.entrySet().stream().filter(e->e.getValue() > 1).findFirst();
        return firstRepeatingElement.isPresent()? firstRepeatingElement.get().getKey(): -1;
    }

    public static void main(String[] args) {
       int[] arr = {10, 5, 3, 4, 3, 5, 6};
       int result = getFirstRepeatingElement(arr);
       System.out.println(result);
    }
}
