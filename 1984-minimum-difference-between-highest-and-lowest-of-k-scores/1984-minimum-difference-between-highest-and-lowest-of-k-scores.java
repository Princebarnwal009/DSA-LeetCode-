class Solution {
    public int minimumDifference(int[] arr, int k) {
        Arrays.sort(arr);
        if(arr.length==1) return 0;
        int minDiff =  Integer.MAX_VALUE;
    
        for(int i=0;i<=arr.length-k;i++){
            int min  = arr[i+k-1]-arr[i];
            minDiff = Math.min(min,minDiff);
        }
    return minDiff;
    }
}