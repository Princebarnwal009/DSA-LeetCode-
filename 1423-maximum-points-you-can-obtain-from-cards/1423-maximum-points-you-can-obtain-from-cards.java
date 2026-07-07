class Solution {
    public int maxScore(int[] arr, int k) {
        int lsum = 0;
        int rsum = 0;

        // Take first k elements from the left
        for (int i = 0; i < k; i++) {
            lsum += arr[i];
        }
        int maxsum = lsum;

        int rindex = arr.length - 1;

        // Now gradually replace left picks with right picks
        for (int i = k - 1; i >= 0; i--) {
            lsum -= arr[i];          // remove one from left
            rsum += arr[rindex];     // add one from right
            rindex--;
            maxsum = Math.max(maxsum, lsum + rsum);
        }

        return maxsum;
    }
}
