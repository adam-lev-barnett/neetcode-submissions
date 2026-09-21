class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;

        int minLength = Integer.MAX_VALUE;
        int localSum = 0;

        while (r < nums.length) {
            if (l == r && nums[l] == target) return 1;

            while (localSum < target && r < nums.length) {
                localSum += nums[r];
                r++;
            }

            while (localSum >= target && l < r) {
                localSum -= nums[l];
                l++;
                minLength = Math.min(minLength, r - l + 1);
            }

        }
        return minLength < Integer.MAX_VALUE ? minLength : 0;
    }
}