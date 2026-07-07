class Solution {
    public int findLengthOfLCIS(int[] arr) {
        if(arr.length ==0 ) return 0;
        int left  = 0;
        int maxLength =  1;

        for(int right = 1; right < arr.length; right++){
            // Expanding window
            if(arr[right] > arr[right-1]){
                maxLength =  Math.max(maxLength,right-left+1);
            }
            // shrinking 
           else {
            left  = right;
           }
        }
        return maxLength;
    }
}