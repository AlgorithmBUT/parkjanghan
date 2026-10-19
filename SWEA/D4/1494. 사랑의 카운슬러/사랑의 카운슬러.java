import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static long[][] points;
    static boolean[] selected;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            points = new long[N][2];
            selected = new boolean[N];
            answer = Long.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Long.parseLong(st.nextToken());
                points[i][1] = Long.parseLong(st.nextToken());
            }

            combination(0, 0);

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(sb);
    }

    // start: 다음에 선택할 수 있는 인덱스
    // count: 현재까지 선택한 개수
    static void combination(int start, int count) {

        if (count == N / 2) {
            long sumX = 0;
            long sumY = 0;

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    sumX += points[i][0];
                    sumY += points[i][1];
                } else {
                    sumX -= points[i][0];
                    sumY -= points[i][1];
                }
            }

            long result = sumX * sumX + sumY * sumY;
            answer = Math.min(answer, result);
            return;
        }

        // 남은 인원으로 N/2개를 채울 수 있는 경우만 탐색
        int need = N / 2 - count;

        for (int i = start; i <= N - need; i++) {
            selected[i] = true;
            combination(i + 1, count + 1);
            selected[i] = false;
        }
    }
}