class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> visited = new HashSet<>();
        
        if (s.length() == 0) return 0;

        int L = 0;
        int R = 1;

        int maxLength = 1;

        int localLength = 1;

        visited.add(s.charAt(L));

        while (R < s.length()) {
            
            if (!visited.contains(s.charAt(R))) {
                
                visited.add(s.charAt(R));
                if (visited.size() > maxLength) maxLength = visited.size();
                R++;
            }
            
            else {
                while (visited.contains(s.charAt(R))) {
                    visited.remove(s.charAt(L));
                    L++;
                }
            }
            
        }

        return maxLength;
        
    }
}
