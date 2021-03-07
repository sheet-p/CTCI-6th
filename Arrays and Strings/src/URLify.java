public class URLify {
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        //finding true length
        int truelen = findLastCharacter(str) + 1;

        //count spaces
        int spaces = countSpaces(str, truelen);

        replaceSpaces(arr, truelen);

        System.out.println(" ");
        for(char ch : arr)
            System.out.print(ch);
    }

    private static int findLastCharacter(String str) {
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) != ' ')
                return i;
        }
        return -1;
    }

    private static int countSpaces(String str, int len) {
        int spaces = 0;
        for(int i=0; i<len; i++) {
            if(str.charAt(i) == ' ')
                spaces++;
        }
        return spaces;
    }

    //assuming string has sufficient space at the end
    private static void replaceSpaces(char[] str, int len) {
        int index = str.length-1;
        for(int i=len-1; i>=0; i--) {
            if(str[i] == ' ') {
                str[index] = '0';
                str[index-1] = '2';
                str[index-2] = '%';
                index = index-3;
            }
            else {
                str[index] = str[i];
                index--;
            }
        }
    }
}
