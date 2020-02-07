public class GameOfLife{

    int size;
    int[][] board;
    int[][] previous;

    public GameOfLife() {

    }

    public GameOfLife(int n){
        this.size = n;
        this.board = new int[n][n];
        this.previous = new int[n][n];

    }

    public GameOfLife(int[][] board){
        size = board.length;
        this.board = new int[size][size];
        this.previous = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.previous[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = board[i][j];
            }
        }

    }

    public int[][] getBoard() {
        return board;
    }

    public int neighbors(int row, int col) {
        int count = 0;
        int prevRow = row - 1;
        int prevCol = col - 1;
        int nextCol = col + 1;
        int nextRow = row + 1;

        if (row != 0 && col != 0) {
            if (previous[prevRow][prevCol] == 1) count++;
        }

        if (row != 0) {
            if (previous[prevRow][col] == 1) count++;
        }

        if (row != 0 && col != previous.length - 1) {
            if (previous[prevRow][nextCol] == 1) count++;

        }
        if (col != 0) {
            if (previous[row][prevCol] == 1) count++;
        }

        if (col != previous.length - 1) {
            if (previous[row][nextCol] == 1) count++;
        }

        if (row != previous.length - 1 && col != 0) {
            if (previous[nextRow][prevCol] == 1)count++;
        }

        if (row != previous.length - 1) {
            if (previous[nextRow][col] == 1) count++;
        }

        if (row != previous.length - 1 && col != previous.length - 1) {
            if (previous[nextRow][nextCol] == 1) count++;
        }
        return count;
    }

    public void oneStep(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.previous[i][j] = board[i][j];
            }
        }
        int checkingCell;
        //Traverse 2D array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                checkingCell = previous[i][j];
                //Case of checking a dead cell
                if (checkingCell == 0){

                    //If a dead cell has exactly three neighbors it becomes an alive cell
                    if (neighbors(i, j) == 3)board[i][j] = 1;
                }
                else if (checkingCell == 1){
                    //Cell dies if it has less than two neighbors
                    if (neighbors(i, j) < 2) board[i][j] = 0;
                    //Cell dies if it has more than three neighbors
                    if (neighbors(i, j) > 3) board[i][j] = 0;
                    //If the cell has 2 or 3 live neighbors it stays alive
                }
            }
        }
    }

    public void evolution(int n){
        for (int i = 0; i < n; i++) {
            oneStep();
        }
    }

    public void printBoards(){
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous.length; j++) {
                System.out.print(previous[i][j]);
            }
            System.out.println("");
        }
        System.out.println("___________________________");
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("___________________________");

    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        GameOfLife test = new GameOfLife(arr);

        test.printBoards();
        test.oneStep();
        test.printBoards();
    }

}