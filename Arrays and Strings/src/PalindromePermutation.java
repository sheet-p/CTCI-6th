import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public static void main(String[] args) {
        String str = "tact coa";
        Set<Character> perm = new HashSet<>();
        for(char ch : str.toCharArray()) {
            if(ch == ' ')
                continue;
            if(! perm.contains(ch))
                perm.add(ch);
            else
                perm.remove(ch);
        }

        if(perm.size() <= 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
