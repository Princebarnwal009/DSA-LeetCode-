class Solution {
    public int maxProduct(int[] nums) {
    int n = nums.length;
      int ans =  nums[0];
      int leftProduct = 1;
      int rightProduct = 1;
      for(int i = 0; i < nums.length; i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];

            ans = Math.max(ans,Math.max(leftProduct,rightProduct));
      }
      return ans;
    }
}