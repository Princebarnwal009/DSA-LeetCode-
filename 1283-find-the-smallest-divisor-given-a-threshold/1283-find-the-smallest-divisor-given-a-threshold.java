class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right  =  0;
        for(int num : nums ){
            right = Math.max(right,num);
        }
        int ans =  right;
        while(left <= right){
            int mid =  left + (right-left)/2;
            if(canDevide(nums,threshold,mid)){
                ans = mid;
             right =  mid-1; // try for smaller
            }
            else {
                left = mid+1; // need for larger value
            }
        }
        return ans;
    }

    private boolean canDevide(int[] nums,int threshold,int divisor){
        int sum = 0;
        for(int num : nums){
           sum += (int) Math.ceil((double) num / divisor);
            if(sum > threshold)  return false;
        }
        return true;
    }
}