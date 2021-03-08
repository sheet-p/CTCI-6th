import java.util.HashSet;
import java.util.Set;

public class OneAway {
    public static void main(String[] args) {
        String s1 = "pkle", s2="pable";


        if(s1.length() > s2.length())
            setCheck(s1, s2);
        else
            setCheck(s2, s1);

    }

    private static void setCheck(String s1, String s2) {
        Set<Character> letters = new HashSet<>();

        //add all characters from 1st set into set
        for(char ch : s1.toCharArray())
            letters.add(ch);

        //remove as and when they're seen in s2
        for(char ch : s2.toCharArray())
            letters.remove(ch);

        if(letters.size() <= 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
