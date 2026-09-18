import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] arr, int target) {
        // Step 1: Copy array with indices
        int[][] nums = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            nums[i][0] = arr[i]; // value
            nums[i][1] = i;      // original index
        }

        // Step 2: Sort by value
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Two-pointer search
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left][0] + nums[right][0];
            if (sum == target) {
                return new int[]{nums[left][1], nums[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // no solution found
    }
}
