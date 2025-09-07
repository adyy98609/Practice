import java.util.*;
import java.util.stream.Collectors;

public class CaseInsensitiveFirstString {

    public static void main(String[] args) {

        String que = "Reya Is is the the best player in Eye eye game";
        getNonRepeatedSentence(que);
    }

    private static void getNonRepeatedSentence(String sentence) {
        List<String> sentenceList = Arrays.stream(sentence.split(" ")).toList();
        Set<String> result = new LinkedHashSet<>();
        for(String word: sentenceList){
            if(result.add(word.toLowerCase())){
                System.out.print(word + " ");
            }
        }
    }
}
