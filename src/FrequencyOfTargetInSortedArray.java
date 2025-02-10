import java.util.*;
import java.util.stream.Collectors;

public class FrequencyOfTargetInSortedArray {

    private static int frequencyOfTargetInSortedArray(int[] arr,int target){
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        for (int j : arr) {
            frequencyMap.put(j, Collections.frequency(list,j));
        }
        return frequencyMap.getOrDefault(target,0);
    }

    public static void main(String[] args) {
         int[] arr = {1,1,2,2,2,3};
         int target = 2;
         int result = frequencyOfTargetInSortedArray(arr,target);
         System.out.println(result);
    }
}
