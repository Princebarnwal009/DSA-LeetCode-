class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right < arr.length ; right++){
            // expanding the window 
            sum +=  arr[right]; 

            // shrinking the window
            while(sum >=  target){ 
                sum -=  arr[left];
                minLength = Math.min(minLength,right-left+1);
                left++;
            }
        }
        return minLength ==  Integer.MAX_VALUE ? 0 : minLength;
    }
}