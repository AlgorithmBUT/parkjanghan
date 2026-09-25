import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{

    static int N, X, M, TC;
    static int[][] rules;
    static int maxCnt = 0;
    static int[] result;
    static int[] hams;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            rules = new int[M][3];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                rules[i][0] = Integer.parseInt(st.nextToken());
                rules[i][1] = Integer.parseInt(st.nextToken());
                rules[i][2] = Integer.parseInt(st.nextToken());
            }

            hams = new int[N+1];
            maxCnt = -1;
            result = new int[N+1];
            solve(1, 0);

            if (maxCnt == -1) System.out.println("#" + tc + " " + maxCnt);
            else {
                System.out.print("#" + tc + " ");
                for (int i = 1; i <= N; i++){
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void solve(int depth, int total){ //depth 번째를 고를 차례

        if (!isPossible(depth, total)) return;

        if (depth == N+1){  //  N+1을 골라야 할 차례 -> 다 채웠다는 뜻
            if (maxCnt < total){
                maxCnt = total;
                result = Arrays.copyOf(hams, N+1);
            }
            return;
        }

        for (int i = 0; i <= X; i++){
            hams[depth] = i;
            solve(depth+1, total + i);
        }

    }

    public static boolean isPossible(int depth, int total){
        for (int[] rule : rules){
            int l = rule[0];
            int r = rule[1];
            int s = rule[2];

            if (depth - 1 == r) {
                int sum = 0;
                for (int i = l; i <= r; i++){
                    sum += hams[i];
                }
                if (sum != s) return false;
            }
        }

        return true;
    }

}