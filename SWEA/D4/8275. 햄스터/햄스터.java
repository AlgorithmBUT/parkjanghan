import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{

    static int N, X, M, TC;
    static int[][] rules;
    static int maxCnt = 0;
    static int[] result;

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

            int[] hams = new int[N];
            maxCnt = -1;
            result = new int[N];
            solve(0, hams);

            if (maxCnt == -1) System.out.println("#" + tc + " " + maxCnt);
            else {
                System.out.print("#" + tc + " ");
                for (int i = 0; i < N; i++){
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void solve(int depth, int[] hams){
        if (depth == N){
            if (isPossible(hams)){
                // System.out.println(Arrays.toString(hams));
                int sum = 0;
                for (int h : hams){
                    sum += h;
                }

                if (sum > maxCnt){
                    maxCnt = sum;
                    result = Arrays.copyOf(hams, N);
                }
            }
            return;
        }

        if (isFailRule(depth, hams)) return;

        for (int i = 0; i <= X; i++){
            hams[depth] = i;
            solve(depth+1, hams);
        }

    }

    public static boolean isPossible(int[] hams){
        for (int[] rule : rules){
            int l = rule[0];
            int r = rule[1];
            int s = rule[2];
            int sum = 0;
            for (int i = l; i <= r; i++){
                sum += hams[i-1];
            }

            if (sum != s) return false;
        }

        return true;
    }

    public static boolean isFailRule(int depth, int[] hams){
        for (int[] rule : rules){
            if (rule[1] == depth){
                int l = rule[0];
                int r = rule[1];
                int s = rule[2];
                int sum = 0;
                for (int i = l; i <= r; i++){
                    sum += hams[i-1];
                }
                if (sum != s) return true;
            }
        }
        return false;
    }
}