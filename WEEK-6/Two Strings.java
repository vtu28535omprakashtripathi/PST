import java.util.*;

public class Solution {

    public static String twoStrings(String s1, String s2) {

        // Store characters of first string
        boolean[] present = new boolean[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            present[ch - 'a'] = true;
        }

        // Check characters of second string
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (present[ch - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {

            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(twoStrings(s1, s2));
        }

        sc.close();
    }
}
