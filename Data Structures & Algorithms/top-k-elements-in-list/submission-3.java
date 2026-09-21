class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums) {
            if (!freqs.containsKey(num)) freqs.put(num, 0);
            freqs.put(num, freqs.get(num) + 1);
        }


        int highestFreq = -1;
        int currentCandidate = -1;

        int count = 0;
        while (count < k) {
            for (int num : freqs.keySet()) {
                if (freqs.get(num) > highestFreq) {
                    currentCandidate = num;
                    highestFreq = freqs.get(num);
                }
            }
            res.add(currentCandidate);
            freqs.remove(currentCandidate);
            count++;
            highestFreq = -1;
            currentCandidate = -1;
        }

        return res.stream().mapToInt(i -> i).toArray();
        
    }
}
