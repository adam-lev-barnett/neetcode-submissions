class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numIndex = new HashMap<>();
        int[] res = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            numIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numIndex.containsKey(diff) && numIndex.get(diff) != i) {
                res[0] = Math.min(i, numIndex.get(diff));
                res[1] = Math.max(i, numIndex.get(diff));
            }
        }
        return res;
    }




}
