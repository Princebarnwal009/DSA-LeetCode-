class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen =  new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++){
                char c =  s.charAt(right);
                // shrink window if dublicates found and remove duplicate
                while(seen.contains(c)){
                    seen.remove(s.charAt(left));
                    left++;
                }

                // add elemet to seen
                seen.add(c);

                // update the maxlen

                maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}