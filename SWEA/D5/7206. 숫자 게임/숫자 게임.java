import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static int[] memo = new int[100000];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(memo, -1);

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int number = Integer.parseInt(br.readLine());

            int answer = dfs(number);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static int dfs(int number) {

        // 한 자리 수면 더 이상 자를 수 없음
        if (number < 10) {
            return 0;
        }

        // 이미 계산한 숫자
        if (memo[number] != -1) {
            return memo[number];
        }

        String str = Integer.toString(number);

        int maxTurn = 0;
        int len = str.length();

        // 숫자 사이를 자르는 모든 경우
        for (int mask = 1; mask < (1 << (len - 1)); mask++) {

            int product = 1;
            int start = 0;

            // 각 숫자 사이 확인
            for (int i = 0; i < len - 1; i++) {

                // 현재 위치에서 자르는 경우
                if ((mask & (1 << i)) != 0) {

                    int num = Integer.parseInt(
                            str.substring(start, i + 1)
                    );

                    product *= num;

                    start = i + 1;
                }
            }

            int num = Integer.parseInt(str.substring(start));
            product *= num;

            maxTurn = Math.max(
                    maxTurn,
                    1 + dfs(product)
            );
        }

        memo[number] = maxTurn;

        return maxTurn;
    }
}