
import java.io.*;

class Result {

    public static int marsExploration(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected;

            if (i % 3 == 1)
                expected = 'O';
            else
                expected = 'S';

            if (s.charAt(i) != expected)
                count++;
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(Result.marsExploration(s));

        br.close();
    }
}