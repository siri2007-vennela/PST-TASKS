import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Store height -> name
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort heights in descending order
        Integer[] sortedHeights = new Integer[n];

        for (int i = 0; i < n; i++) {
            sortedHeights[i] = heights[i];
        }

        Arrays.sort(sortedHeights, Collections.reverseOrder());

        // Build result
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = map.get(sortedHeights[i]);
        }

        return result;
    }
}
