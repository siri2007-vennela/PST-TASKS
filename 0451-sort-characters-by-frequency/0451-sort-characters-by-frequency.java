import java.util.*;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sort characters by frequency
        List<Character> chars = new ArrayList<>(map.keySet());

        Collections.sort(chars, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return map.get(b) - map.get(a);
            }
        });

        // Build result
        StringBuilder ans = new StringBuilder();

        for (char c : chars) {
            for (int i = 0; i < map.get(c); i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}