import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] grid = new int[N][N];
            int[][] sum = new int[N+1][N+1];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    if (st.hasMoreTokens()) grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++){
                    sum[i][j] = grid[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
                }
            }

            int MAX = 0;
            for (int i = M; i <= N; i++){
                for (int j = M; j <= N; j++){
                    int square = sum[i][j] - sum[i-M][j] - sum[i][j-M] + sum[i-M][j-M];
                    MAX = Math.max(MAX, square);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(MAX);

            System.out.println(sb);
        }

    }
}