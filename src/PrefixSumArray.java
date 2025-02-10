import java.util.Arrays;

/**
 * Prefix sum involves preprocessing an array to create new array
 * where each element at index i represents the sum of the array
 * from the start up to i.This helps for efficient sum queries on subarrays
 *
 * Sample Problem:
 * Given an array nums, answer multiple queries about the sum of elements within a specific range [i, j].
 *
 * Example:
 *
 * Input: nums = [1, 2, 3, 4, 5, 6], i = 1, j = 3
 *
 * Output: 9
 *
 * Explanation:
 * Preprocess the array A to create a prefix sum array: P = [1, 3, 6, 10, 15, 21].
 *
 * To find the sum between indices i and j, use the formula: P[j] - P[i-1].
 */
public class PrefixSumArray {

    private final  int[] prefix;

    public PrefixSumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for(int i=0;i<nums.length;++i){
            prefix[i+1] = nums[i] + prefix[i];
        }
    }

    public int sumRange(int left, int right) {
        int sum =  prefix[right+1] - prefix[left];
        System.out.println(sum);
        return sum;

    }
    public static void main(String args[]){
        int[] num = {-2, 0, 3, -5, 2, -1};
        PrefixSumArray prefixSumArray = new PrefixSumArray(num);
        prefixSumArray.sumRange(0,2);
    }
}
