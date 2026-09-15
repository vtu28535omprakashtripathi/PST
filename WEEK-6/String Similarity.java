import java.io.*;
import java.util.*;

public class Solution {

    public static int stringSimilarity(String s) {
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            // Compare prefix with suffix starting at i
            while (i + count < n &&
                   s.charAt(count) == s.charAt(i + count)) {
                count++;
            }

            total += count;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            System.out.println(stringSimilarity(s));
        }

        sc.close();
    }
}
