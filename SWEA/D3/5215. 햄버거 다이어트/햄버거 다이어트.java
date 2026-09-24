import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.nio.file.Files.move;

class Solution{

    public static int TC;
    public static int N, L;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            int[] weights = new int[N+1];
            int[] points = new int[N+1];

            for (int i = 1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                points[i] = Integer.parseInt(st.nextToken());
                weights[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][L+1];

            for (int i = 1; i <= N; i++){
                for (int j = 0; j <=L; j++){
                    if (j >= weights[i]){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weights[i]] + points[i]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }

                }
            }



            System.out.println("#" + tc + " " + dp[N][L]);
        }
    }

}