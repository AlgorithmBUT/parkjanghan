import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

class Solution{

    static int TC;
    static int N;
    static int ANSWER;
    static int trees[];
    static int left[];
    static int TARGET;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            left = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            TARGET = -1;
            for (int i = 0; i < N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
                TARGET = Math.max(TARGET, trees[i]);
            }

            int odd = 0;
            int even = 0;
            for (int i = 0; i < N; i++){
                left[i] = TARGET - trees[i];
                even += (left[i] / 2);
                odd += (left[i] % 2 == 1)? 1 : 0;
            }

            // System.out.println(Arrays.toString(left));
            // System.out.println("even : " + even + " / odd : " + odd);
            //========================================
            ANSWER = Math.max(even, odd) * 2;
            if (ANSWER != even * 2) ANSWER -= 1;

            while (even >= odd){
                even -= 1;
                odd += 2;

                int ans = Math.max(even, odd) * 2;
                if (ans != even * 2) ans -= 1;

                ANSWER = Math.min(ANSWER, ans);
            }

            System.out.println("#" + tc + " " + ANSWER);
        }
    }

}