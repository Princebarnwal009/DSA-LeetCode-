class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxFruits = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to basket
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // Shrink window if more than 2 types
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++; //  Always move left forward
            }

            // Update max window size
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
