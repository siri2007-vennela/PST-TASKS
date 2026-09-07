
import java.io.*;
import java.util.*;

class Result {

    public static String twoStrings(String s1, String s2) {
        boolean[] seen = new boolean[26];

        for (char c : s1.toCharArray()) {
            seen[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (seen[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(br.readLine().trim());

        while (q-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            String result = Result.twoStrings(s1, s2);

            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}

