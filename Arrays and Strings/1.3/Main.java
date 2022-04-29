/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are giver the true
 * length of the string.
 */

public class Main {

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int n = 13;
        System.out.println(URLify(s, n));
    }
    
    /** Solution using a character array.
    /** Optimal solution: O(N) time and no extra space in memory*/
    public static String URLify(String s, int n) {
        int diff = s.length() - n;
        char[] str = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                str[i + diff] = str[i];
            } else {
                str[i + diff] = '0';
                str[i - 1 + diff] = '2';
                str[i - 2 + diff] = '%';
                diff -= 2;
            }
        }
        return new String(str);
    }

}
