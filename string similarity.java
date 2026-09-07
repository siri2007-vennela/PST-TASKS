
import java.io.*;
import java.util.*;

class Result {

    public static int stringSimilarity(String s) {
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int j = 0;

            while (i + j < n && s.charAt(j) == s.charAt(i + j)) {
                j++;
            }

            total += j;
        }

        return total;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();

            int result = Result.stringSimilarity(s);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}

