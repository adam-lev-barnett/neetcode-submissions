class Solution {
    public int maxProfit(int[] prices) {

        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            int localProfit = 0;
            if (prices[l] < prices[r]) {
                localProfit = prices[r] - prices[l];
                maxProfit = Math.max(localProfit, maxProfit);
            }
            else {
                l = r;
            }
            r++;
        }

        return maxProfit;
        
    }
}
