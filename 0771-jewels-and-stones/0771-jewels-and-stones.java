class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        // put all jewels element into set for quick lookup
        for(char c : jewels.toCharArray()){
            jewelSet.add(c);
        }
    
        // count how many stone are jewels 
        int count = 0;
        for(char c : stones.toCharArray()){
            if(jewelSet.contains(c)){
                count++;
            }
        }
        return count;
    }
}