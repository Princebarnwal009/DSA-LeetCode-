class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int day : bloomDay){
            left = Math.min(left,day);
            right = Math.max(right,day);
        }

        int ans = -1;
        while(left <=  right){
            int mid =  left + (right-left)/2;
            if(canBloom(bloomDay,m,k,mid)){
                ans = mid;
                right =  mid-1; // tyr for minnimum

            }
            else {
                left  =  mid+1;
            }
        }
        return ans;
    }


    private boolean canBloom(int[] bloomDay,int m,int k,int day){
        int bouqets = 0;
        int flower = 0;
        for(int bloom : bloomDay){
            if(bloom <= day ){
                flower++;
                if(flower == k){
                    flower = 0;
                    bouqets++;
                }
            }
            else{
                flower = 0;
            }
        }
        return bouqets>=m;
    }
}