import java.util.Arrays;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            // If left is odd and right is even, swap
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
            // Move left pointer if it's even
            if (nums[left] % 2 == 0) {
                left++;
            }
            // Move right pointer if it's odd
            if (nums[right] % 2 == 1) {
                right--;
            }
        }
        
        return nums;
    }

    // Optional: for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sol.sortArrayByParity(nums1))); 
        // Possible output: [2, 4, 3, 1] or [4, 2, 1, 3]

        int[] nums2 = {0};
        System.out.println(Arrays.toString(sol.sortArrayByParity(nums2))); 
        // Output: [0]
    }
}
