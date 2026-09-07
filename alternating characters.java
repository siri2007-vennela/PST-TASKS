
import java.io.*;
import java.util.*;

class Result {

    public static int alternatingCharacters(String s) {
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }

        return count;
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
            String s = br.readLine();

            int result = Result.alternatingCharacters(s);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}

