class NumMatrix {

    int rows;
    int cols;
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.sumMatrix = new int[rows][cols];

        // Populate prefix sums for each row
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                sumMatrix[i][j] = sum;
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for (int i = row1; i <= row2; i++) {
            int subtotal = sumPrefix(i, col1, col2);
            total += subtotal;
        }
        return total;
    }

    public int sumPrefix(int row, int leftBound, int rightBound) {
        int sum = sumMatrix[row][rightBound];
        sum -= leftBound == 0 ? 0 : sumMatrix[row][leftBound - 1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */