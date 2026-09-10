import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static int B;
    static int[] height;
    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            height = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            answer = Integer.MAX_VALUE;

            dfs(0, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int depth, int sum) {

        // 이미 선반 높이 이상이면 정답 후보
        if (sum >= B) {
            answer = Math.min(answer, sum - B);
            return;
        }

        // 모든 직원을 확인한 경우
        if (depth == N) {
            return;
        }

        // 현재 직원 선택
        dfs(depth + 1, sum + height[depth]);

        // 현재 직원 선택 X
        dfs(depth + 1, sum);
    }
}