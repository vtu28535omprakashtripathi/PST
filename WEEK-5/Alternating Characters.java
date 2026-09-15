import java.io.*;
import java.util.*;

public class Solution {

    public static int alternatingCharacters(String s) {

        int deletions = 0;

        for (int i = 1; i < s.length(); i++) {

            // If current and previous characters are same
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }

        return deletions;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            String s = sc.next();

            System.out.println(alternatingCharacters(s));
        }

        sc.close();
    }
}
