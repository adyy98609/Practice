import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem statement :
 * You are given an integer n and an integer array arr of size n+2.
 * All elements of the array are in the range from 1 to n.
 * Also, all elements occur once except two numbers which occur twice.
 * Find the two repeating numbers.
 * Note: Return the numbers in their order of appearing twice.
 * So, if x and y are repeating numbers,
 * and x's second appearance comes before the second appearance of y,
 * then the order should be (x, y).
 * <p>
 * Example 1: Input: n = 4, arr[] = [1, 2, 1, 3, 4, 3]
 * Output: 1 3
 * Explanation: In the given array, 1 and 3 are repeated two times,
 * and as 1's second appearance occurs before 2's second appearance, so the output should be 1 3.
 * <p>
 * Example 2 : Input: n = 2, arr[] = [1, 2, 2, 1]
 * Output: 2 1
 * Explanation: In the given array,
 * 1 and 2 are repeated two times and second occurence of 2 comes before 1.
 * So the output is 2 1.
 */
public class TwoRepeatedElements {

    private static int[] twoRepeatedElements(int [] arr){
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) == 2) {
                resultList.add(num);
            }
        }

        int[] result = new int[2];
        result[0] = resultList.get(0);
        result[1] = resultList.get(1);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 4, 3};
        int[] result = twoRepeatedElements(arr);
        System.out.println(Arrays.toString(result));
    }
}
/**
 * import java.util.*;
 *
 * public class TwoRepeatedElements {
 *
 *     private static int[] twoRepeatedElements(int[] arr) {
 *         Map<Integer, Integer> countMap = new HashMap<>();
 *         List<Integer> resultList = new ArrayList<>();
 *
 *         for (int num : arr) {
 *             countMap.put(num, countMap.getOrDefault(num, 0) + 1);
 *             if (countMap.get(num) == 2) {
 *                 resultList.add(num);
 *             }
 *         }
 *
 *         int[] result = new int[2];
 *         result[0] = resultList.get(0);
 *         result[1] = resultList.get(1);
 *
 *         return result;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] arr = {1, 2, 2, 1, 4, 3};
 *         int[] result = twoRepeatedElements(arr);
 *         System.out.println(Arrays.toString(result)); // Output: [2, 1]
 *     }
 * }
 */
