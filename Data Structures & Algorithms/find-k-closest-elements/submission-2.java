class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // Handle case where x is 0 and distance is same for a and b
        // a comes first if a < b
        // if distance is the same (ie., x is between two potential answers) lower number gets precedence

        int l = 0;
        int r = arr.length - 1;
        List<Integer> res = new ArrayList<>();

        //Start in, build outward
        while (l < arr.length - 1 && arr[l] <= x) l++;
        while (r > l && arr[r] >= x) r--;

        // Decrement l if they're at the same index so we don't add unnecessary numbers
        if (l == r) {
            if (l == 0) r++;
            else l--;
        }

        int lDiff;
        int rDiff;

        while (res.size() < k && l >= 0 && r < arr.length) {
            lDiff = Math.abs(x - arr[l]);
            rDiff = Math.abs(x - arr[r]);

            // Still need to account for if they're equal
            if (lDiff <= rDiff ) {
                res.add(arr[l]);
                l--;
            }
            else {
                res.add(arr[r]);
                r++;
            }

        }

        while (res.size() < k) {
            if (l < 0) {
                res.add(arr[r]);
                r++;
            }
            else if (r >= arr.length) {
                res.add(arr[l]);
                l--;
            }
        }



        Collections.sort(res);

        return res;
        
    }
}