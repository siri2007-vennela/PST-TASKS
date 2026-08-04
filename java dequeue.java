import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Use generics so removeFirst() returns Integer
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> freq = new HashMap<>();

        int n = in.nextInt(); // total number of integers
        int m = in.nextInt(); // size of subarray

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // Maintain window size = m
            if (deque.size() > m) {
                int removed = deque.removeFirst(); // now returns Integer
                freq.put(removed, freq.get(removed) - 1);
                if (freq.get(removed) == 0) {
                    freq.remove(removed);
                }
            }

            // Update max unique count when window size == m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, freq.size());
            }
        }

        System.out.println(maxUnique);
    }
}
