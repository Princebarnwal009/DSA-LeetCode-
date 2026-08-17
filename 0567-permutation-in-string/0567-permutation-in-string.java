class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] countS1 = new int[26];
        int[] countWindow = new int[26];

        // Count frequency of characters in s1
        for (char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length(); i++) {
            countWindow[s2.charAt(i) - 'a']++;

            // Maintain window size equal to s1 length
            if (i >= s1.length()) {
                countWindow[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Compare frequency arrays
            if (matches(countS1, countWindow)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
