class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] ans  =  new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] =  nums[i];
         }
         Arrays.sort(nums);
         if(Arrays.equals(nums,ans)) return 0;
         int x = -1;
         int y = -1;
         for(int i  = 0;i <ans.length;i++){
                if(nums[i] != ans[i]){
                    if(x == -1){
                        x = i;
                    }
                    y = i;
                }
         }
         return y-x+1;
    }
}