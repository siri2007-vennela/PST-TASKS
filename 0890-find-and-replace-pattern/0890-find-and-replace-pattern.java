
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            int[] a = new int[26];
            int[] b = new int[26];
            boolean ok = true;

            for (int i = 0; i < pattern.length(); i++) {
                int x = pattern.charAt(i) - 'a';
                int y = word.charAt(i) - 'a';

                if (a[x] != b[y]) {
                    ok = false;
                    break;
                }

                a[x] = i + 1;
                b[y] = i + 1;
            }

            if (ok)
                ans.add(word);
        }

        return ans;
    }
}
