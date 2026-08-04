import java.util.Arrays;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;

        // Interleave x1,y1,x2,y2,...,xn,yn
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];     // xi
            result[index++] = nums[i + n]; // yi
        }

        return result;
    }

    // Optional: for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(sol.shuffle(nums1, 3)));
        // Output: [2, 3, 5, 4, 1, 7]

        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sol.shuffle(nums2, 4)));
        // Output: [1, 4, 2, 3, 3, 2, 4, 1]

        int[] nums3 = {1, 1, 2, 2};
        System.out.println(Arrays.toString(sol.shuffle(nums3, 2)));
        // Output: [1, 2, 1, 2]
    }
}
