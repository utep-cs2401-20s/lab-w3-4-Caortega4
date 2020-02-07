import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GOLTester {

    @Test
    public void testNeighbors1(){
        int[][] arr = {
                //   2
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},//2
                {0,0,0,0,0},
                {0,0,0,0,0}
                        };
        GameOfLife sol = new GameOfLife(arr);

        assertEquals(2, sol.neighbors(2, 2));

    }

    @Test
    public void testNeighbors2(){
        int[][] arr = {
                //     3
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},//1
                {0,0,1,1,1,0},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
                        };
        GameOfLife sol = new GameOfLife(arr);

        assertEquals(3, sol.neighbors(1, 3));

    }

    @Test
    public void testNeighbors3(){
        int[][] arr = {
                {0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}
        };
        GameOfLife sol = new GameOfLife(arr);

        assertEquals(4, sol.neighbors(2, 3));

    }

    @Test
    public void testNeighbors4(){
        int[][] arr = {
              // 0
                {0,0,0,0,0,0},//0
                {0,0,0,0,0,0},
                {0,0,1,1,1,0},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };
        GameOfLife sol = new GameOfLife(arr);

        assertEquals(0, sol.neighbors(0, 0));

    }

    @Test
    public void testNeighbors5(){
        int[][] arr = {
                       //4
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0},//row 5
                {0,0,0,1,0,1,0,1,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0}
        };
        GameOfLife sol = new GameOfLife(arr);

        assertEquals(6, sol.neighbors(5, 4 ));

    }

    @Test
    public void testOneStep(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        int[][] expected = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };

        TorusGameOfLife sol = new TorusGameOfLife(arr);
        sol.oneStep();
        assertEquals(expected, sol.getBoard());

    }
    }
