import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosest {

    //Brute force approach
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int res =0;
        for(int i=0;i<nums.length - 2;i++){
            for(int j=i+1;j<nums.length -1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int currentSum = nums[i] + nums[j] + nums[k];
                    int currDiff = Math.abs(currentSum - target);

                    // if currentDiff is less than minDiff, it indicates
                    // that this triplet is closer to the target
                    if(currDiff < closestSum){
                        res = currentSum;
                        closestSum = currDiff;
                    }
                    // If multiple sums are closest, take maximum one
                    else if( currDiff == closestSum){
                        res = Math.max(res,currentSum);
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    //Optimal solution - Two pointer approach
    private static int threeSumClosestOptimalSolution(int[] nums, int target){
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        for(int i=0;i<nums.length -1;++i){
           int j= i+1;
           int k = nums.length -1;
           while(j<k){
               int currSum = nums[i] + nums[j] + nums[k];
               if(currSum == target){
                   return currSum;
               }
               if(Math.abs(currSum - target) < Math.abs(closestSum - target)){
                   closestSum = currSum;
               }
               if(currSum < target){
                   j++;
               }else{
                   k--;
               }

           }
        }
        System.out.println(closestSum);
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        threeSumClosest(nums,1);
        threeSumClosestOptimalSolution(nums,1);
    }
}
