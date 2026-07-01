class Solution {
    public int removeDuplicates(int[] arr) {

        int k = 0;

        for (int i = 0; i < arr.length; i++) {

            if (k < 2 || arr[i] != arr[k - 2]) {
                arr[k] = arr[i];
                k++;
            }
        }

        return k;
    }
}