import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

class Solution{

    static int TC;
    static int N;
    static int ANSWER;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());

            //========================================
            memo = new int[100000];
            Arrays.fill(memo, -1);

            ANSWER = dfs(N);

            System.out.println("#" + tc + " " + ANSWER);
        }
    }

    public static int dfs(int N){
        if (memo[N] != -1) return memo[N];
        String str = Integer.toString(N);

        int maxCnt = 0;
        for (int mask = 1; mask < (1 << str.length() - 1); mask++){

            int product = 1;
            int start = 0;

            for (int i = 0; i < str.length() - 1; i++){
                if ((mask & (1 << i)) != 0){
                    int num = Integer.parseInt(str.substring(start, i+1));
                    product *= num;
                    start = i+1;
                }
            }
            product *= Integer.parseInt(str.substring(start, str.length()));
            maxCnt = Math.max(maxCnt, dfs(product) + 1);
        }

        memo[N] = maxCnt;
        return maxCnt;
    }
}