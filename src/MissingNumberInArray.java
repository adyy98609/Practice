import java.util.Arrays;
import java.util.List;

public class MissingNumberInArray {

    private static int missingNumber(int[] arr,int n){
        int res = 0;
        List<Integer> list = Arrays.stream(arr).boxed().sorted().toList();
        int startNumber = list.getFirst();
        for(int i=startNumber;i<=n;i++){
            if(!list.contains(i)){
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
       int[] arr = {1, 2, 4, 6, 3, 7, 8};
       int n = 8;
       int result = missingNumber(arr,n);
       System.out.println(result);
    }
}
