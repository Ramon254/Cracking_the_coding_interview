/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str = "abcd12345rvt";
        System.out.println(isUnique(str));
    }

    /** Solution using additional data structures. */
    /** Optimal solution: O(N) time */
    public static boolean isUnique(String str) {
        HashMap <Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    /** Solution without using data structures. */
    /** Optimal solution without using more space. O(N^2) time. */
    public static boolean isUniqueDS(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
