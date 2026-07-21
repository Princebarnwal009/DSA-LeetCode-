class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0;
        int maxCap = 0;
        
        // find bounds
        for (int weight : weights) {
            minCap = Math.max(minCap, weight);
            maxCap += weight;
        }
        
        // binary search
        while (minCap < maxCap) {
            int mid = minCap + (maxCap - minCap) / 2;
            int sum = 0;
            int dayCount = 1;
            
            for (int weight : weights) {
                if (sum + weight > mid) {
                    dayCount++;
                    sum = 0;
                }
                sum += weight;
            }
            
            if (dayCount > days) {
                // need more days → capacity too small
                minCap = mid + 1;
            } else {
                // capacity works → try smaller
                maxCap = mid;
            }
        }
        
        return minCap;
    }
}
