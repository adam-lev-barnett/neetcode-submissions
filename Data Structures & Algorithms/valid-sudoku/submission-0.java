class Solution {

    Map<Integer, Set<Character>> columns = new HashMap<>();
    Map<Integer, Set<Character>> miniBoxes = new HashMap();
    Set<Character> miniBox0 = new HashSet<>();
    Set<Character> miniBox1 = new HashSet<>();
    Set<Character> miniBox2 = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            if (!isValidRow(board[i])) return false;
            if (i % 3 == 0) {
                miniBox0.clear();
                miniBox1.clear();
                miniBox2.clear();
            } 

            for (int j = 0; j < board[i].length; j++) {
                char currChar = board[i][j];
                if (currChar == '.') continue;
                if (!addToMiniBox(currChar, j)) return false;
                Set<Character> currentCol = columns.computeIfAbsent(j, (k) -> new HashSet<>());
                if (currentCol.contains(board[i][j])) return false;
                if (!currentCol.add(currChar)) return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[] row) {
        Set<Character> rowCheck = new HashSet<>();
        for (char c : row) {
            if (c == '.') continue;
            if (rowCheck.contains(c)) return false;
            rowCheck.add(c);
        }
        return true;
    }

    private boolean addToMiniBox(char c, int j) {
        if (c == '.') return true;
        if (j < 3) {
            return miniBox0.add(c);
        }
        else if (j < 6) {
            return miniBox1.add(c);
        }
        return miniBox2.add(c);
    }


}
