class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] pres = new int[size];
        int[] sufs = new int[size];
        int[] res = new int[size];

        pres[0] = 1;
        sufs[size - 1] = 1;

        for (int i = 1; i < size; i++) {
            pres[i] = pres[i - 1] * nums[i-1]; 
        }

        for (int i = size - 2; i >= 0; i--) {
            sufs[i] = sufs[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < size; i++) {
            res[i] = sufs[i] * pres[i];
        }

        return res;
    }
}  
