class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = arr[0]+arr[1]+arr[2];
        for(int i = 0; i<arr.length-2; i++){
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
                int sum =  arr[i]+arr[j]+arr[k];
                if(Math.abs(ans-target) > Math.abs(sum-target)){
                    ans = sum;
                }
                
                if(sum == target){
                    return sum;
                }
                if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }
}