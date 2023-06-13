public class URLify {
    public static void main(String[] args) {
        String str = "Mr John Smith      ";
        char[] arr = str.toCharArray();
        //finding true length
        int truelen = findLastCharacter(str) + 1;

        replaceSpaces(arr, truelen);

        System.out.println(" ");
        for(char ch : arr)
            System.out.print(ch);
    }

    //assuming string has sufficient space at the end
    private static void replaceSpaces(char[] str, int truelen) {
        int spaces = countSpaces(str, truelen);

        //index keeps track of the pointer for the replacement array
        int index = truelen + (spaces * findLastCharacter("%20"));

        if (truelen < str.length) 
            str[truelen] = '\0';

        for(int i=truelen-1; i>=0; i--) {
            if(str[i] == ' ') {
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index-3;
            }
            else {
                str[index-1] = str[i];
                index--;
            }
        }
    }

    private static int findLastCharacter(String str) {
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) != ' ')
                return i;
        }
        return -1;
    }

    private static int countSpaces(char[] str, int len) {
        int spaces = 0;
        for(int i=0; i<len; i++) {
            if(str[i] == ' ')
                spaces++;
        }
        return spaces;
    }
}
