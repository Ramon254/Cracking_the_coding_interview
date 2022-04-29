/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring of
 * another. Given two strings, s1, and s2, write code to check if s2 is a rotation of s1 using only one 
 * call to isSubstring.
 */

public class Main {

    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";
        System.out.println(isRotation(s2, s1));
    }

    /** Solution using one call to isSubstring (contains) */
    /** Solution in O(N) time where N is the length of the bigger string */
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() <= 0 || s1.length() != s2.length()) return false;
        int index = 0, found = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(index) && found == 0) {
                found = i;
                index++;
            } else if (s2.charAt(i) == s1.charAt(index)) {
                index++;
            } else if (s2.charAt(i) != s1.charAt(index) && found != 0) {
                return false;
            }
        }
        String aux = s2.substring(0, found);
        return s1.contains(aux); // In the book, this is the isSubstring function.
    }

}
