class Solution {
    public int minSpeedOnTime(int[] nums, double hour) {
        int left = 1;
        int right = 10000000;
        for(int num : nums){
            left =  Math.min(left,num);
            right =  Math.max(right,num);
        }
            int ans  = -1;
            while(left <=  right){
                int mid = left + (right-left)/2;
                if(possibleSpeed(nums,hour,mid)){
                    ans =  mid;
                 right = mid-1;
                }
                else {
                    left =  mid + 1;
                }
            }
        return ans;
    }



   private boolean possibleSpeed(int[] dist, double hour, int speed) {
    double totalTime = 0.0;

    // Handle all trains except the last
    for (int i = 0; i < dist.length - 1; i++) {
        totalTime += Math.ceil((double) dist[i] / speed);
        if (totalTime > hour) return false; // early exit
    }

    // Add the last train with exact division
    totalTime += (double) dist[dist.length - 1] / speed;

    return totalTime <= hour;
}

}