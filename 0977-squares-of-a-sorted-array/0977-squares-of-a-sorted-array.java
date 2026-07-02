class Solution {
    public int[] sortedSquares(int[] arr) {
       int n = arr.length;
        int[] ans = new int[n];
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
           
            if(Math.abs(arr[i]) < Math.abs(arr[j])){
                ans[n-1] = arr[j]*arr[j];
                n--;
                j--;
            }
            else{
                ans[n-1]=arr[i]*arr[i];
                n--;
                i++;
            }

            }
        
        return ans;
    }
}