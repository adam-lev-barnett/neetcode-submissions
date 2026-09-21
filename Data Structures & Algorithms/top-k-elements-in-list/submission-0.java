class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        HashMap<Integer, Integer> numFrequency = new HashMap<>();
        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(numFrequency.entrySet());

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }

        return res;
    }


}
