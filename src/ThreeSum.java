import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 */
public class ThreeSum {

    //n(3) solution
    private static List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> threeSumList = new ArrayList<>();
        int sum =0;
        for (int i=0;i<nums.length -2 ; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for(int k=j+1;k<nums.length;k++){
                    sum = nums[i] + nums[j] + nums[j + 1];
                    if (sum == 0 && !threeSumList.contains(List.of(nums[i], nums[j], nums[j + 1]))) {
                        List<Integer> ansList = new ArrayList<>();
                        ansList.add(nums[i]);
                        ansList.add(nums[j]);
                        ansList.add(nums[j + 1]);
                        threeSumList.add(ansList);
                    }
                }
            }
        }
        System.out.println(threeSumList);
        return threeSumList;
    }

    private static List<List<Integer>> threeSumOptimalSolution(int[] nums){
        List<List<Integer>> threeSumList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i]>0) {
                break;
            }
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k = nums.length - 1;
            while (j<k){
                int sum =nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                }else{
                    threeSumList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k){
                        j++;
                        if(nums[j] != nums[j-1]){
                            break;
                        }
                    }
                    while(j < k){
                        k--;
                        if(nums[k] != nums[k+1]) break;
                    }
                }
            }
        }
        System.out.println(threeSumList);
        return threeSumList;
    }


    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        threeSum(nums);
        threeSumOptimalSolution(nums);

    }
}
