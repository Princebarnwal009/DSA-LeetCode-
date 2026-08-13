class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a','i','e','o','u');
        int count  = 0;
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
            // Expanding the wiindow
            if(vowels.contains(s.charAt(i))) count++;
            // shrinking the window
            if(i>=k  && vowels.contains(s.charAt(i-k))) count--;
             
             maxCount =  Math.max(maxCount,count);

        }
        return maxCount;
    }
}