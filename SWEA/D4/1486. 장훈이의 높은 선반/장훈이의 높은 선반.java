import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

class Solution{

    static int TC;
    static int N, B = 0;
    static int ANSWER;
    static int[] heights, remainSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                heights[i] = Integer.parseInt(st.nextToken());
            }

            remainSum = new int[N+1];
            for (int i = N-1; i >= 0; i--){
                remainSum[i] = remainSum[i+1] + heights[i];
            }

            //========================================
            ANSWER = Integer.MAX_VALUE;
            dfs(0, 0);

            System.out.println("#" + tc + " " + (ANSWER - B));
        }

    }

    public static void dfs(int depth, int total){     // depth 번째 heights를 고를 차례, heights[depth-1] 까지의 합
        if (depth == N){
            if (total >= B) ANSWER = Math.min(ANSWER, total);
            return;
        }

        if (remainSum[depth] + total < B) return;


        // depth번째 선택
        dfs(depth + 1, total + heights[depth]);

        // depth 번째 선택 x
        dfs(depth + 1, total);

    }

}