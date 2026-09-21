class Solution {
    public int maxArea(int[] heights) {
        int L = 0;
        int R = heights.length - 1;
        int maxVolume = 0;

        while (L < R) {
            System.out.printf("Max volume = %d\n", maxVolume);
            System.out.printf("L = %d; R = %d\n", L, R);
            System.out.printf("Left height = %d; Right height = %d\n", heights[L], heights[R]);
            int localVolume = calculateVolume( Math.min(heights[L], heights[R]), (R - L) );

            if (localVolume > maxVolume) {
                maxVolume = localVolume;
            }
            if (heights[R] >= heights[L]) L++;
            else R--;
        }

        return maxVolume;
    }

    public int calculateVolume(int minimum, int width) {
        System.out.printf("Local volume is %d\n\n", minimum*width);
        return minimum * width;
    }
}
