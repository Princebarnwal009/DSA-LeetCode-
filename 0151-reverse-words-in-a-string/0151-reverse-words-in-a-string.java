class Solution {
    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();
        int n = chars.length;

        // Step 1: reverse the entire string
        reverse(chars, 0, n - 1);

        int l = 0, r = 0, i = 0;
        while (i < n) {
            // copy characters until space
            while (i < n && chars[i] != ' ') {
                chars[r++] = chars[i++];
            }
            // reverse the word
            if (l < r) {
                reverse(chars, l, r - 1);
                if (r < n) {
                    chars[r++] = ' ';
                }
                l = r;
            }
            i++;
        }

        // ✅ Only trim trailing space if present
        if (r > 0 && chars[r - 1] == ' ') {
            r--;
        }

        return new String(chars, 0, r);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
