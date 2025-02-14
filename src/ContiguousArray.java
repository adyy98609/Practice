import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * */
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int s=0;
        int maxLength = 0;
        for(int i=0;i<nums.length;i++){
            s += nums[i] ==1 ? 1 : -1;
            if(map.containsKey(s)){
                maxLength = Math.max(maxLength, i - map.get(s));
            }else{
                map.put(s,i);
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,0,0};
        findMaxLength(nums);

    }

}
