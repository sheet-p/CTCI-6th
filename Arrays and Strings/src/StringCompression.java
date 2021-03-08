public class StringCompression {
    public static void main(String[] args) {
        String str = "aabccccaa";
        System.out.println(compressed(str));
    }

    private static String compressed(String str) {
        StringBuilder comp = new StringBuilder();
        int consecutive = 0;

        for(int i=0; i<str.length(); i++) {
            consecutive++;

            if(i+1>=str.length() || str.charAt(i) != str.charAt(i+1)) {
                comp.append(str.charAt(i));
                comp.append(consecutive);
                consecutive = 0;
            }
        }

        return comp.length() < str.length() ? comp.toString() : str;
    }
}
