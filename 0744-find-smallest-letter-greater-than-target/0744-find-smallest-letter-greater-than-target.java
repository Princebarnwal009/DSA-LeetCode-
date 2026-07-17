
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (letters[mid] <= target) {
                left = mid + 1; // move right
            } else {
                right = mid - 1; // move left
            }
        }
        
        // If left goes out of bounds, wrap around to the first element
        return letters[left % letters.length];
    }
}
