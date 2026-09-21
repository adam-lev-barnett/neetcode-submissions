class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        String stripped = s.replaceAll("\\p{Punct}", "")
                            .replaceAll("\\s", "")
                            .toLowerCase();
        int r = stripped.length() - 1;
        System.out.println("New string: " + stripped);

        // Until left pointer crosses over right pointer
        while (l <= r) {
            System.out.println("Left pointer: " + l);
            System.out.println("Right pointer: " + r);
            if (stripped.charAt(l) != stripped.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
