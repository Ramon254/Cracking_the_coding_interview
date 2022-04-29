/**
 * String compression: Implement a method to perform basic string compression using the counts of 
 * repeated characters. If the compressed string would not become smaller than the original string,
 * your method should return the original string. You can assume the string has only uppercase
 * and lowercase letters (a - z).
 */

public class Main {
    
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compression(str));
        String str2 = "abca";
        System.out.println(compression(str2));
    }

    /** Solution creating the new string using a char array */
    /** Optimal solution in O(N) time where N is the length of the string with extra O(N) Space */
    public static String compression(String str) {
        char[] newStr = new char[str.length() * 2];
        int count = 0;
        char aux = ' ';
        int pointer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != aux) {
                if (aux != ' ') {
                    newStr[pointer] = aux;
                    newStr[pointer + 1] = Character.forDigit(count, 10);
                    pointer += 2;
                }
                aux = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        newStr[pointer] = aux;
        newStr[pointer + 1] = Character.forDigit(count, 10);
        String str2 = new String(newStr).trim();
        return (str.length() <= str2.length()) ? str : str2;
    }

}
