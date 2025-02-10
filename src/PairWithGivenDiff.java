import java.util.*;

/**
 * Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
 * Output: Pair Found: (2, 80)
 */
public class PairWithGivenDiff {

    private static Set<List<Integer>> getPairWithGivenDiff(int[] arr,int requiredDiff){
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new LinkedHashSet<>();
        int left = 0;
        int right = 1;
        while (left < right && right<arr.length){
            int diff = Math.abs(arr[left] - arr[right]);
            if(diff == requiredDiff){
                list.add(arr[left]);
                list.add(arr[right]);
                set.add(list);
                break;
            }
            else if(diff>requiredDiff){
                left++;
            }else{
                right++;
            }
        }
        return set;
    }

    public static void main(String[] args) {
       int[] arr= {1, 8, 30, 40, 100};
       Set<List<Integer>> set = getPairWithGivenDiff(arr,60);
       System.out.println(set);
    }
}
