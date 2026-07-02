import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] ans = nums.clone();

        Arrays.sort(nums);

        if (Arrays.equals(ans, nums))
            return 0;

        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            if (ans[i] != nums[i]) {
                if (x == -1)
                    x = i;
                y = i;
            }
        }

        return y - x + 1;
    }
}