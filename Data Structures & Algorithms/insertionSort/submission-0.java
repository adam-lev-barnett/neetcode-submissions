// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> lists = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (pairs.get(j).key < pairs.get(j - 1).key) {
                    swap(j, j - 1, pairs);
                }
            }
            lists.add(new ArrayList<>(pairs));
        }
        return lists;
    }

    private void swap(int i, int j, List<Pair> pairs) {
        Pair temp = pairs.get(j);
        pairs.set(j, pairs.get(i));
        pairs.set(i, temp);
    }

}
