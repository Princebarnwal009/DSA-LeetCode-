class Solution {
    public int[][] insert(int[][] arr, int[] newInterval) {
        int[][] result =  new int[arr.length+1][2];
        int i = 0;
        int j  = 0;
        // for non overlapping
        while(i<arr.length && arr[i][1]< newInterval[0]){
            result[j++] = arr[i++];
        }

        while(i<arr.length && arr[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(arr[i][0],newInterval[0]);
              newInterval[1] = Math.max(arr[i][1],newInterval[1]);
              i++;
        }
            result[j++] = newInterval;

            while(i<arr.length){
                result[j++] = arr[i++];
            }
        return java.util.Arrays.copyOf(result,j);
    }
}