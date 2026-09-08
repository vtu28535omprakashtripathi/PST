import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();

            int mid = n / 2;

            String left = s.substring(0, mid);
            String right;

            if (n % 2 == 0) {
                right = s.substring(mid);
            } else {
                right = s.substring(mid + 1);
            }

            char[] l = left.toCharArray();
            char[] r = right.toCharArray();

            Arrays.sort(l);
            Arrays.sort(r);

            if (Arrays.equals(l, r)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
