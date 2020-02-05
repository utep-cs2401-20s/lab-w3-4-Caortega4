public class TorusGameOfLife extends GameOfLife {
    int size;
    int[][] board;
    int[][] previous;

    @Override
    public int neighbors(int row, int col) {
        int prevRow = (row + size - 1) % size;
        int prevCol = (col + size - 1) % size;
        int nextRow = (row + size + 1) % size;
        int nextCol = (col + size + 1) % size;

        int count = 0;

        if (previous[prevRow][prevCol] == 1) count++;
        if (previous[prevRow][col] == 1) count++;
        if (previous[prevRow][nextCol] == 1) count++;
        if (previous[row][prevCol] == 1) count++;
        if (previous[row][nextCol] == 1) count++;
        if (previous[nextRow][prevCol] == 1)count++;
        if (previous[nextRow][col] == 1) count++;
        if (previous[nextRow][nextCol] == 1) count++;



        return count;
    }
}
