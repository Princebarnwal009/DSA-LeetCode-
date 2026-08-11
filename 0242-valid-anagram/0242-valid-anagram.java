class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq =  new int[26];
        // count charecter in s 
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        // subtract charecter in t
        for(int i = 0;i <t.length();i++){
            freq[t.charAt(i)-'a']--;
        }

        for(int count : freq){
            if(count != 0) return false;
        }
        return true;
     }
}