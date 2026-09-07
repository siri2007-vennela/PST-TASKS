import java.io.*;
import java.util.*;

class Result {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;

        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;

            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            if (sum == d)
                count++;
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String[] arr = br.readLine().trim().split(" ");
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(arr[i]));
        }

        String[] input = br.readLine().trim().split(" ");
        int d = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int result = Result.birthday(s, d, m);

        System.out.println(result);

        br.close();
    }
}
