class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        System.out.println(counts.toString());

        int max = -1;

        for (int elem : counts.keySet()) {
            if (counts.get(elem) > counts.getOrDefault(max, 0)) max = elem;
        }

        return max;
    }
}