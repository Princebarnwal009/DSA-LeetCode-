
class Solution {
    public int largestPerimeter(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = n - 1; i > 1; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                return arr[i] + arr[i - 1] + arr[i - 2];
            }
        }
        return 0; // no valid triangle
    }
}
