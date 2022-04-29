/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they
 * are one edit (or zero edits) away.
 */

public class Main {
 
    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "bake"));
    }
    
    /** Solution checking the three posible cases */
    /** Optimal solution in O(N) time where N is the length of the first string */
    public static boolean oneAway(String first, String second) {
        if (first.length() == second.length()) 
            return oneReplace(first, second);
        else if (first.length() + 1 == second.length())
            return oneInsert(first, second);
        else if (first.length() == second.length() + 1)
            return oneInsert(second, first);
        else return false;
    }

    public static boolean oneReplace(String first, String second) {
        boolean diff = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                }
            }
        }
        return true;
    }

    public static boolean oneInsert(String first, String second) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < first.length() && i2 < second.length()) {
            if (first.charAt(i1) != second.charAt(i2)) {
                if (i1 != i2) {
                    return false;
                }
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        return true;
    }

}
