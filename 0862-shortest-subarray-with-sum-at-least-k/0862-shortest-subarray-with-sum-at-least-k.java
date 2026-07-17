import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Step 1: Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        // Step 2: Use deque to maintain candidate indices
        Deque<Integer> deque = new ArrayDeque<>();
        int result = n + 1;
        
        for (int i = 0; i <= n; i++) {
            // Step 3: Check if we can form a valid subarray
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            
            // Step 4: Maintain monotonic increasing prefix sums
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
        }
        
        return result == n + 1 ? -1 : result;
    }
}
