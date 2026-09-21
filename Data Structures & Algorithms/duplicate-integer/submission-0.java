class Solution {


    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> dupes = new HashMap<>();

        for (int num : nums) {
            boolean counted = dupes.getOrDefault(num, false);
            System.out.println(counted);
            if (counted == false) {
                dupes.put(num, true);
                continue;
            }
            return true;
        }
        return false;
        
    }
}