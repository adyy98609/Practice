import java.util.*;
import java.util.stream.Collectors;

public class CaseInsensitiveFirstString {

    public static void main(String[] args) {

        String que = "Reya is is the the best player in eye eye game";
        getNonRepeatedSentence(que);
    }

    private static void getNonRepeatedSentence(String sentence){
        List<String> wordsList = Arrays.stream(sentence.split(" ")).toList();
        List<String> wordsListCopy = List.copyOf(wordsList);
        System.out.println("For final result : "+wordsListCopy);
        Map<String,Integer> wordCount = new LinkedHashMap<>();
        List<String> output = wordsList.stream().map(String::toLowerCase).toList();
        System.out.println("List after making each String lowercase : "+output);
        output.forEach(e->{
            wordCount.put(e,Collections.frequency(output,e));
        });
        System.out.println(wordCount);
        final List<String> result = new ArrayList<>(wordCount.keySet());
        result.forEach(e->{
            Optional<String> word = wordsListCopy.stream().filter(dup->dup.equalsIgnoreCase(e)).findFirst();
            System.out.print(word.get() +" ");
        });
    }
}
