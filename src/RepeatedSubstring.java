import java.util.*;

public class RepeatedSubstring {

    private static void repeatedSubStringCount(){
       String word = "abc def abc jklm opq";
       List<String> wordList = Arrays.stream(word.split(" ")).toList();
       System.out.println(wordList);
       Map<String,Integer> frequencyMap = new HashMap<>();
       wordList.forEach(e->{
           frequencyMap.put(e, Collections.frequency(wordList,e));
       });
        System.out.println(frequencyMap);

    }

    public static void main(String[] args) {
        repeatedSubStringCount();
    }
}
