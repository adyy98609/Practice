import java.util.Arrays;
import java.util.List;

public class Anagram {

    private static boolean isAnagram(String s1, String s2){
        List<Character> s1List = s1.toLowerCase().chars().mapToObj(e-> (char) e).toList();
        System.out.println(s1List);
        List<Character> s2List = s2.toLowerCase().chars().mapToObj(c-> (char) c).toList();
        s1List.stream().sorted();
        s2List.stream().sorted();
        boolean isAnagram = s1List.containsAll(s2List);
        if(isAnagram){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cat","Tao"));
    }
}
