class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int r = 0;
        int sum = 0;
        while (r < k) {
            sum += arr[r];
            r++;
        }
        int l = r - k;
        if (sum / k >= threshold) count++;
        for (; r < arr.length; r++) {
            sum += arr[r];
            sum -= arr[l];
            if (sum / k >= threshold) count++;
            l++;
            System.out.println("l = " + l + "\nr = " + r);
        }
        return count;
    }
}