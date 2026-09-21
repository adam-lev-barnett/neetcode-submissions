class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            counts1[Character.toLowerCase(s.charAt(i)) - 'a']++;
            counts2[Character.toLowerCase(t.charAt(i)) - 'a']++;
        }

        System.out.println(Arrays.toString(counts1));
        System.out.println(Arrays.toString(counts2));


        return Arrays.equals(counts1, counts2);
    }
}
