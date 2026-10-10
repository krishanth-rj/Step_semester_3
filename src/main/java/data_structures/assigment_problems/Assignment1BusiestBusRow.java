package data_structures.assigment_problems;

public class Assignment1BusiestBusRow {
    /** Returns {zero-based row index, row total}; equal totals keep the smaller index. */
    public static int[] busiestRow(int[][] grid) {
        int bestIndex = 0;
        int bestTotal = -1;
        for (int row = 0; row < grid.length; row++) {
            int total = 0;
            for (int value : grid[row]) total += value;
            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = row;
            }
        }
        return new int[] {bestIndex, bestTotal};
    }

    // Time: O(r*c). Extra space: O(1), excluding the two-value result.
    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
