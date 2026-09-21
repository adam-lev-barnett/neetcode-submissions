class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        List<String> removeList = new ArrayList<>();
        for (String s : strs) {
            removeList.add(s);
        }
        for (int i = 0; i < strs.length; i++) {
            if (!removeList.contains(strs[i])) continue;
            removeList.remove(strs[i]);
            List<String> wordSet = new ArrayList<>();
            wordSet.add(strs[i]);
            Map<Character, Integer> currentWord = populateCharMap(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(currentWord, populateCharMap(strs[j]))) {
                    wordSet.add(strs[j]);
                    removeList.remove(strs[j]);
                }
            }
            anagrams.add(wordSet);
        }
        return anagrams; 
    }

    private Map<Character, Integer> populateCharMap(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : charArray) {
            int count = charCounts.getOrDefault(c, 0);
            charCounts.put(c, count + 1);
        }
        return charCounts;
    }

    private boolean isAnagram(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        return m1.entrySet().equals(m2.entrySet());
    }
}
