import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MakeAnagram {

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        makeAnagram(a,b);
    }

    private static int makeAnagram(String a, String b){
        List<Character> aCharacterList = a.toLowerCase().chars().mapToObj(c->(char) c).sorted().toList();
        List<Character> bCharacterList = b.toLowerCase().chars().mapToObj(c->(char) c).sorted().toList();
        System.out.println("acharacterList "+aCharacterList);
        System.out.println("bcharacterList "+bCharacterList);
        List<Character> result = new ArrayList<>();
        for (Character character : bCharacterList) {

               if(!aCharacterList.contains(character)){
                  result.add(character);
               }

        }
        System.out.println(result);
        System.out.println(result.size());
        return result.size();
    }
}
