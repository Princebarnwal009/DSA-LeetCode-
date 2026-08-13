class Solution {
    public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result =  new ArrayList<>();
            int[] pCount = new int[26];
            int[] sCount =  new int[26];
            // count the freq of p
            for(char c : p.toCharArray()){
                pCount[c-'a']++;
            }

            // Aplly sliding window here
            for(int i=0;i<s.length();i++){
                  
                  sCount[s.charAt(i)-'a']++;

                // Shrink the window if window size is greater than p.length()
                  if(i>=p.length()){
                    sCount[s.charAt(i-p.length())-'a']--;
                  }

                // comapre the string are anagram or not 

                if(Arrays.equals(pCount,sCount)){
                    result.add(i-p.length()+1);
                }

            }
            return result;
    }
}