class Solution {
    public int splitArray(int[] nums, int k) {
        int left= 0;
        int right = 0;
        for(int num : nums){
            left = Math.max(left,num);
            right += num;
        }

        int ans  =  right;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(canSplit(nums,k,mid)){
                ans =  mid;
                right =  mid-1; // need smaalller ans

            }
            else {
                left =  mid+1; // need for the larger
            }
        }
        return ans;
    }


    private boolean canSplit(int[] nums,int k,int maxSum){
        int count = 1;
        int currSum = 0;
        for(int num : nums){
            if(currSum+num >  maxSum){
                count++;
                currSum = num;
                if(count > k) return false;
            }
            else {
                currSum +=  num;
            }
        }
        return true;
    }
}