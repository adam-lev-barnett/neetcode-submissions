class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;


        while (r > l) {
            if (heights[r] > heights[l]) {
                max = Math.max((r - l) * heights[l], max);
                l++;
            }
            else {
                max = Math.max((r - l) * heights[r], max);
                r--;
            }
        }

        return max;
    }
}
