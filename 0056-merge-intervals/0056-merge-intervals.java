import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] curr = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap case
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            // No overlap case
            else {
                result.add(curr);
                curr = intervals[i];
            }
        }

        // Add the last merged interval
        result.add(curr);

        return result.toArray(new int[result.size()][]);
    }
}