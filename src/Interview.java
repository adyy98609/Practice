import java.util.*;

// initialize an arraY WITH days of week - String array
//sort the array in ascending order of the vowels present in them
public class Interview {


    public static void main(String[] args) {
        String[] arr = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        List<String> list = Arrays.stream(arr).toList();
        Map<String,Integer> vowelCount = new LinkedHashMap<>();
        list.forEach(e->{
            int count = 0;
            for(char c: e.toLowerCase().toCharArray()){
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    count++;
                }
                vowelCount.put(e,count);
            }

        });
        System.out.println(vowelCount);
        List<String> sorted = vowelCount.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
        System.out.println(sorted);
    }

}
