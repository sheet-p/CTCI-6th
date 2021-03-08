public class StringRotation {
    public static void main(String[] args) {
        String s1="macbook", s2="bookmac";

        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        //check if same length
        if(s1.length() == s2.length() && s1.length()>0) {
            return isSubstring(s2+s2, s1);
        }
        return false;
    }

    private static boolean isSubstring(String big, String small) {
        if(big.indexOf(small) >= 0)
            return true;
        return false;
    }
}
