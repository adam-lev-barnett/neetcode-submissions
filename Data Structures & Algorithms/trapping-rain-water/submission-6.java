class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if (size < 3) return 0;

        int lBound = 0;
        int rBound = size - 1;
        int maxHeight = height[0];

        // set l-bound
        while (lBound < size - 2 && height[lBound] >= maxHeight) {
            maxHeight = height[lBound];
            lBound++;
            if (lBound >= size - 1) return 0;
        }
        lBound--; // adjust back to the starting peak index

        maxHeight = height[rBound];

        // set r-bound
        while (rBound > lBound && height[rBound] >= maxHeight) {
            maxHeight = height[rBound];
            rBound--;
        }
        rBound++;

        if (rBound <= lBound + 1) return 0;

        int res = 0;
        int l = lBound;

        // Process forward when a taller or equal right wall exists
        while (l < rBound) {
            int maxL = height[l];
            int nextR = l + 1;

            // Search ahead for a bar at least as tall as height[l]
            while (nextR <= rBound && height[nextR] < maxL) {
                nextR++;
            }

            if (nextR <= rBound) {
                // Taller or equal bar found: collect water using height[l] as wall
                for (int i = l + 1; i < nextR; i++) {
                    res += maxL - height[i];
                }
                l = nextR; // Advance left anchor to the newly found peak
            } else {
                // No taller bar found: sweep backward from rBound to l using right peaks
                int maxR = height[rBound];
                for (int i = rBound - 1; i > l; i--) {
                    if (height[i] >= maxR) {
                        maxR = height[i];
                    } else {
                        res += maxR - height[i];
                    }
                }
                break; // Segment complete
            }
        }

        return res;
    }
}