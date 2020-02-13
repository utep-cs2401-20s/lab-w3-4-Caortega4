public class GameOfLife{

    int size;
    int[][] board;
    int[][] previous;

    //Default constructor
    public GameOfLife() {

    }

    //Constructor with n size boards
    public GameOfLife(int n){
        this.size = n;
        this.board = new int[n][n];
        this.previous = new int[n][n];

    }

    //Constructor with input 2D array
    public GameOfLife(int[][] board){
        size = board.length;
        this.board = new int[size][size];
        this.previous = new int[size][size];

        //Copies the 2D array to previous
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.previous[i][j] = board[i][j];
            }
        }

        //Copies the 2D array to the actual board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = board[i][j];
            }
        }

    }

    //Returns the 2D board
    public int[][] getBoard() {
        return board;
    }

    //Returns the number of alive neighbors of a cell with indices (row, col)
    public int neighbors(int row, int col) {
        int count = 0;
        int prevRow = row - 1;
        int prevCol = col - 1;
        int nextCol = col + 1;
        int nextRow = row + 1;

        //If statements to check if the cell's neighbors are not out of bounds
        if (row != 0 && col != 0) {
            //If the cell is alive increment count
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

    //Takes the board to its next state
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

        //Prints the board to visualize what is happening
        printBoards();
    }

    public void evolution(int n){
        for (int i = 0; i < n; i++) {
            oneStep();
        }
    }

    //Prints the previous board and the latest state of board
    public void printBoards(){

        System.out.println("Previous board");
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous.length; j++) {
                System.out.print(previous[i][j]);
            }
            System.out.println("");
        }


        System.out.println("___________________________");
        System.out.println("Actual board");
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("___________________________");

    }

}