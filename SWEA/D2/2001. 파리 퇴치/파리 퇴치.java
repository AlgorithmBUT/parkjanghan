import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();

            int[][] grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int maxSum = 0;

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = add_sum(grid, i, j);
                    maxSum = Math.max(maxSum, sum);
                }
            }

            System.out.println("#" + test_case + " " + maxSum);
        }
    }

    public static int add_sum(int[][] grid, int startY, int startX) {

        int sum = 0;

        for (int i = startY; i < startY + M; i++) {
            for (int j = startX; j < startX + M; j++) {
                sum += grid[i][j];
            }
        }

        return sum;
    }
}
