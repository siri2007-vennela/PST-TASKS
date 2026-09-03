class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0)
                count++;
        }

        for (int i = n / 2; i < n; i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0)
                count--;
        }

        return count == 0;
    }
}