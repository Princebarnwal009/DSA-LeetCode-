import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) return result;

        // Frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // We try sliding windows starting at different offsets
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // If we see too many of one word, shrink from left
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If we matched all words
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
