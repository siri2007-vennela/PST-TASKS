
import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();

        for (int start = 0; start < n; start++) {
            String t = s.substring(start) + s.substring(0, start);
            ans.add(longestPalindrome(t));
        }

        return ans;
    }

    static int longestPalindrome(String s) {
        int n = s.length();
        int best = 1;

        for (int i = 0; i < n; i++) {

            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                best = Math.max(best, r - l + 1);
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                best = Math.max(best, r - l + 1);
                l--;
                r++;
            }
        }

        return best;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        List<Integer> result = Result.circularPalindromes(s);

        for (int x : result) {
            bw.write(String.valueOf(x));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
