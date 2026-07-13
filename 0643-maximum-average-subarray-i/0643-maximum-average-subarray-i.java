class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left  = 0;
        double maxAvg = Integer.MIN_VALUE;
        double avg  = 0;
        double sum = 0;
        for(int right = 0; right < nums.length; right++){
                sum += nums[right];
                // Shrinking 
                while(right-left+1>k){
                    sum-=nums[left];
                    left++;
                }


                if(right-left+1 == k){
                    avg =  sum / k;
                    maxAvg =  Math.max(avg,maxAvg);
                }
        }
        return maxAvg;
    }
}