import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class GameOfLife {

    private static final int NUM_ITERATIONS = 10;

    private static class Cell extends Thread {
        private final boolean[][] grid;
        private final int row;
        private final int col;
        private final CyclicBarrier barrier;

        public Cell(boolean[][] grid, int row, int col, CyclicBarrier barrier) {
            this.grid = grid;
            this.row = row;
            this.col = col;
            this.barrier = barrier;
        }

        private boolean getNextState() {
            int numAlives = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!(i == 0 && j == 0)
                            && row + i >= 0 && row + i < grid.length
                            && col + j >= 0 && col + j < grid[0].length) {
                        if (grid[row + i][col + j]) {
                            numAlives++;
                        }
                    }
                }
            }

            if (!grid[row][col] && numAlives == 3) {
                return true;
            }
            return numAlives == 2 || numAlives == 3;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_ITERATIONS; i++) {

                try {
                    Thread.sleep(1000);
                    boolean nextState = getNextState();
                    barrier.await(); // wait for other threads to read

                    grid[row][col] = nextState;

                    barrier.await(); // wait for others to write gird
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, m = 4;

        boolean[][] grid = new boolean[n][m];
        initGrid(grid);
        CyclicBarrier barrier = new CyclicBarrier(n * m, () -> printGrid(grid));

        // init threads
        Thread[][] cells = new Cell[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cells[i][j] = new Cell(grid, i, j, barrier);
                cells[i][j].start();
            }
        }
    }

    private static void initGrid(boolean[][] grid) {
        Random random = new Random();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    private static void printGrid(boolean[][] grid) {
        for (boolean[] booleans : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(booleans[j] ? 'x' : 'o');
            }
            System.out.println();
        }
        System.out.println();
    }

}
