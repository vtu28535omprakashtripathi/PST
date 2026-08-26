import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            // Add element to deque and set
            deque.add(num);
            set.add(num);

            // Once window reaches size M
            if (deque.size() == m) {
                // Update maximum unique count
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }

                // Optimization: maximum possible unique elements reached
                if (maxUnique == m) {
                    System.out.println(maxUnique);
                    return;
                }

                // Remove the oldest element going out of the window
                int removed = deque.removeFirst();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }

        System.out.println(maxUnique);
    }
}
