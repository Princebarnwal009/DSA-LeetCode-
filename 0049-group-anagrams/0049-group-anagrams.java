import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort the string to use as a key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add the word to the correct group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
