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
        System.out.println("Starting L: arr[" + l + "] = " + arr[l]);
        while (r > l && arr[r] >= x) r--;
        System.out.println("Starting R: arr[" + r + "] = " + arr[r]);

        // Decrement l if they're at the same index so we don't add unnecessary numbers
        if (l == r) {
            if (l == 0) r++;
            else l--;
        }

        int lDiff;
        int rDiff;

        while (res.size() < k && l >= 0 && r < arr.length) {
            System.out.println("L index is " + l);
            System.out.println("R index is " + r);
            lDiff = Math.abs(x - arr[l]);
            System.out.println("L difference is " + lDiff);
            rDiff = Math.abs(x - arr[r]);
            System.out.println("R difference is " + rDiff);
            System.out.println();
            // Still need to account for if they're equal
            if (lDiff <= rDiff ) {
                res.add(arr[l]);
                System.out.println("Adding l's value: " + arr[l]);
                l--;
            }
            else {
                res.add(arr[r]);
                System.out.println("Adding r's value: " + arr[r]);
                r++;
            }
            System.out.println();
            System.out.println("Size of res is: " + res.size());
            System.out.println();
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