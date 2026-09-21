class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> grams = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String sortedKey = new String(ca);
            if (!grams.containsKey(sortedKey)) {
                grams.put(sortedKey, new ArrayList<>());
            }
            grams.get(sortedKey).add(s);
        }

        for (String s : grams.keySet()) {
            res.add(grams.get(s));
        }

        return res;
    }

}
