class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                right = mid; // try smaller maximum
            } else {
                left = mid + 1; // need larger maximum
            }
        }
        return left;
    }
    
    private boolean canDivide(int[] nums, int maxOperations, int maxSize) {
        int ops = 0;
        for (int num : nums) {
            ops += (num - 1) / maxSize;
            if (ops > maxOperations) return false;
        }
        return true;
    }
}
