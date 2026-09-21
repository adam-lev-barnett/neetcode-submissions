class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
        
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        
        int middle = start + (end - start)/2;

        if (nums[middle] == target) return middle;

        else {
            if (end - start <= 0) return nums[start] < target ? start + 1 : start;
            if (target > nums[middle]) return binarySearch(nums, middle + 1, end, target);
            return binarySearch(nums, start, middle, target);
        }

    }
}