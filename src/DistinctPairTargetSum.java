import java.util.*;

public class DistinctPairTargetSum {

    private static Set<Integer> distinctPairTargetSum(int [] arr, int targetSum){
        Set<Integer> pair = new HashSet<>();
        for (int i=0;i<arr.length;i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    pair.add(i);
                    pair.add(j);
                    System.out.println(pair);
                }
            }
        }
        return pair;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     * O(n) solution
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numberMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int numberNeeded = target - nums[i];
            if(numberMap.containsKey(numberNeeded)){
                return new int[]{numberMap.get(numberNeeded),i};
            }
            numberMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr =  {2,7,11,15};
        int targetSum =9;
        Set<Integer> result = distinctPairTargetSum(arr,targetSum);
        twoSum(arr,targetSum);
        System.out.println(result);
    }
}
