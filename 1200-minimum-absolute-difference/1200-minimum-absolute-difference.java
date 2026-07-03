class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        // Step 1: Find minimum difference
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        // Step 2: Collect all pairs with minDiff
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return ans;
    }
}
