import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveAllZerosToEnd {

    private static int[] moveAllZerosToEnd(int[] arr){
        // Pointer to track the position for next non-zero element
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // If the current element is non-zero
            if (arr[i] != 0) {

                // Swap the current element with the 0 at index 'count'
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                // Move 'count' pointer to the next position
                count++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
      int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
      moveAllZerosToEnd(arr);
    }
}
