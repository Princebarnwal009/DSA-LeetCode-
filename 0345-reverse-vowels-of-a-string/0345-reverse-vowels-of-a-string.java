class Solution {
    public String reverseVowels(String s) {
        char[]  chars =  s.toCharArray();
        int left = 0;
        int right =  chars.length-1;
        while(left <  right){
            // move left pointer until found vowel
            while(left<right && !isVowel(chars[left])){
                left++;
            }
            // move right pointer until found vowel
            while(left<right && !isVowel(chars[right])){
                right--;
            }

            char temp = chars[left];
            chars[left] =  chars[right];
            chars[right] =  temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c){
             return "aeiouAEIOU".indexOf(c) != -1;
    }
}