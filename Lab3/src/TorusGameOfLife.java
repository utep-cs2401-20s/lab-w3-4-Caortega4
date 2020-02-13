public class  TorusGameOfLife extends GameOfLife {


    //Torus constructors
    public TorusGameOfLife(){
        super();
    }

    public TorusGameOfLife(int n){
        super(n);
    }

    public TorusGameOfLife(int[][] arr) {
        super(arr);
    }

    //Overrides neighbors to implement the new set of rules that Torus Game of Life has
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
