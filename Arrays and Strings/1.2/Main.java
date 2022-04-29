/**
 * Check permutation: Given two strings, write a method to decide if one is a 
 * permutation of the other.
 */

public class Main { 
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abdc";
        System.out.println(isPermutation(s1, s2));
    }

    /** Solution ordering the characters.
    /** Optimal solution: O(N log N) time */
    public static boolean isPermutation(String s1, String s2) {
        char[] s1aux = s1.toCharArray();
        java.util.Arrays.sort(s1aux); 
        char[] s2aux = s2.toCharArray();
        java.util.Arrays.sort(s2aux); 
        return new String(s1aux).equals(new String(s2aux));
    }

}
