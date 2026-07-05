class Solution {
    public int[][] insert(int[][] arr, int[] new1) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        ArrayList<int[]> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Case 1: current interval ends before new interval starts → add arr[i]
            if (arr[i][1] < new1[0]) {
                result.add(arr[i]);
            }
            // Case 2: current interval starts after new interval ends → add new1, then replace new1 with arr[i]
            else if (arr[i][0] > new1[1]) {
                result.add(new1);
                new1 = arr[i];
            }
            // Case 3: overlap → merge intervals
            else {
                new1[0] = Math.min(new1[0], arr[i][0]);
                new1[1] = Math.max(new1[1], arr[i][1]);
            }
        }
        
        // Add the last interval
        result.add(new1);
        
        return result.toArray(new int[result.size()][]);
    }
}
