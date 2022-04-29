/**
 * Palindrome Permutation: Given a String, write a function to check if it is a permutation of a
 * palindrome. A palindrome is a word or phrase thah is the same forwards and backwards. A permutation
 * is a rearrangement of letters. You can ignore casing and non-letter characters.
 */

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        String pali = "Taco cat";
        System.out.println(isPalindromePermutation(pali));
        System.out.println(buildPalindrome(pali));
    }

    /** Solution using a char table. */
    /** Optimal solution in O(N) time. */
    public static boolean isPalindromePermutation(String s) {
        s = s.toLowerCase();
        boolean odd = false;
        int[] table = new int[128]; // Ascii
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                table[s.charAt(i)]++;
            }
        }
        for (int i : table) {
            if (i % 2 != 0) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }

    /** Extra: just for fun. If the String is a palindrome permutation, build it's palindrome */
    public static String buildPalindrome(String s) {
        if (!isPalindromePermutation(s)) {
            return "";
        }
        s = s.toLowerCase();
        int bigger = 0;
        int spaces = 0; 
        int[] table = new int[128]; // Ascii
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                table[s.charAt(i)]++;
                if (table[s.charAt(i)] > bigger) {
                    bigger++;
                }
            } else {
                spaces++;
            }
        }
        int start = 0; 
        int end = s.length() - spaces - 1; 
        char[] newStr = new char[s.length() - spaces];
        while (bigger > 0) {
            for (int i = 0; i < table.length; i++) {
                if (table[i] == bigger) {
                    newStr[start] = (char) i;
                    newStr[end] = (char) i;
                    start++;
                    end--;
                    table[i] -= 2;
                }
            }
            bigger--;
        }
        return new String(newStr);
    }

}
