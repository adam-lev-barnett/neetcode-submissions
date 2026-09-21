class Solution {
    int[] sols;
    public int climbStairs(int n) {
        sols = new int[n + 1];

        if (n <= 2) return n;

        for (int i = 0; i < 3; i++) {
            sols[i] = i;
        }

        for (int i = 3; i <= n; i++) {
            sols[i] = sols[i - 1] + sols[i - 2];
        }

        return sols[n];
    }
}
