class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // if nagative presents 
       int maxProduct1 =  nums[0]*nums[1]*nums[n-1];

        // if only positive occurs
       int maxProduct2 = nums[n-1]*nums[n-2]*nums[n-3];

        int ans  =  Math.max(maxProduct1,maxProduct2);
        return ans;
    }
}