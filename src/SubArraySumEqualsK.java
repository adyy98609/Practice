import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubArraySumEqualsK {

    private static int findSubArraysWithMaxSum(int[] nums, int k){
        int resp = 0;
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    resp++;
                }
            }
        }
        System.out.println(resp);
        return resp;
    }

    private static int findSubArraysWithMaxSumOptimized(int[] nums , int k){
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;
        int resp = 0;

        for(int i=0;i<nums.length;i++){
            currSum +=nums[i];
            if(currSum == k)
                resp++;
            if(prefixSumMap.containsKey(currSum - k)) {
                resp += prefixSumMap.get(currSum - k);
            }
            prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

        }
        System.out.println(resp);
        return resp;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,1,2,1};
        int k = 3;
        findSubArraysWithMaxSum(nums,k);
        findSubArraysWithMaxSumOptimized(nums,k);
    }
}
