class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while (left <= right) {
            if (Math.abs(arr[left]) < Math.abs(arr[right])) {
                ans[k--] = arr[right] * arr[right];
                right--;
            } else {
                ans[k--] = arr[left] * arr[left];
                left++;
            }
        }
        return ans;
    }
}
