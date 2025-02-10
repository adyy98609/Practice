//Search element in an sorted array by using Binary search

public class BinarySearch {

    //General Binary search
    private static int searchIndex(int[] array, int target){
        int low = 0;
        int high = array.length -1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return  -1;
    }

    //Recursion technique
    private static int searchIndexOfTarget(int[] array, int low, int high, int target){
        if(high >= low){
            int mid = low + (high -low)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                return searchIndexOfTarget(array,mid+1,high,target);
            }else{
                return searchIndexOfTarget(array,low,mid -1,target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = searchIndexOfTarget(arr,0,n -1,x);
        System.out.println(result);

    }
}
