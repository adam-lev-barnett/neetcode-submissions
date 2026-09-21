class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = Math.min(i, map.get(nums[i]));
                res[1] = Math.max(i, map.get(nums[i]));
            }
            else map.put(target - nums[i], i);
        }
        
        return res;
    }
}
