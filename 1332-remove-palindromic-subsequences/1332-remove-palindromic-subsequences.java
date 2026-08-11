class Solution {
    public int removePalindromeSub(String s) {
        if(s.isEmpty()) return 0;
        if(isPallindrom(s)) return 1;
        return 2;
    }

    private boolean isPallindrom(String s){
        int left = 0;
        int right = s.length()-1;
        while(left< right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;

        }
        return true;
    }
}