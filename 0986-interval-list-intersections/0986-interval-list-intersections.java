import java.util.Arrays;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 ||
            secondList == null || secondList.length == 0) {
            return new int[0][];
        }

        int i = 0, j = 0, k = 0;
        int[][] result = new int[firstList.length + secondList.length][2];

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end   = Math.min(firstList[i][1], secondList[j][1]);

            // If they overlap
            if (start <= end) {
                result[k][0] = start;
                result[k][1] = end;
                k++;
            }

            // Move the pointer with smaller end
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(result, k);
    }
}
