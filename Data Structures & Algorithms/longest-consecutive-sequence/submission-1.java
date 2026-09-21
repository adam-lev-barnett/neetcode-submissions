class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> orderedNums = new TreeSet<>();
        for (int num : nums) {
            orderedNums.add(num);
        }
        List<Integer> longestChain = new ArrayList<>();
        int maxChainCount = 0;
        int lastNum = Integer.MIN_VALUE;
        for (int num : orderedNums) {
            // If it's empty, just add the number and continue
            if (longestChain.isEmpty()) {
                longestChain.add(num);
                lastNum = num;
            }
            else {
                // If num is one more than the previous num, add it to the list
                System.out.println("Currently analyzing: " + num);
                if (num == lastNum + 1) {
                    System.out.println(num + " is one greater than " + lastNum);
                    longestChain.add(num);
                    lastNum = num;
                }
                // Update the longest consecutive sequence before deleting the original list
                // Then add the new number to start the new list
                else {
                    System.out.println(num + " is not one greater than " + lastNum);
                    System.out.println("Calculating if current size chain (" + longestChain.size() + ") is greater than " + maxChainCount);
                    longestChain.clear();
                    longestChain.add(num);
                    lastNum = num;
                }
            }
            if (longestChain.size() > maxChainCount) maxChainCount = longestChain.size();
            System.out.println("Current max consecutive sequence: " + maxChainCount);
        }
        return maxChainCount;
        
    }
}
