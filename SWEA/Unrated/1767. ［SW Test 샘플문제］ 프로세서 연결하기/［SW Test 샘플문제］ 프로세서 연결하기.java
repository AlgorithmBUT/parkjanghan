import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static int[][] grid;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위

    static List<Position> processors;

    static int maxCore;
    static int minWire;

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            grid = new int[N][N];
            processors = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());

                    // 가장자리 코어는 이미 연결되어 있으므로 제외
                    if (grid[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            processors.add(new Position(i, j));
                        }
                    }
                }
            }

            maxCore = 0;
            minWire = Integer.MAX_VALUE;

            solve(0, 0, 0);

            System.out.println("#" + tc + " " + minWire);
        }
    }

    // depth : 현재 확인할 코어 번호
    // connected : 지금까지 연결한 코어 개수
    // wireLength : 지금까지 사용한 전선 길이
    static void solve(int depth, int connected, int wireLength) {

        // 모든 코어를 확인한 경우
        if (depth == processors.size()) {

            // 연결한 코어 수가 더 많으면 갱신
            if (connected > maxCore) {
                maxCore = connected;
                minWire = wireLength;
            }

            // 연결한 코어 수가 같으면 전선 길이 최소
            else if (connected == maxCore) {
                minWire = Math.min(minWire, wireLength);
            }

            return;
        }

        // 가지치기
        // 남은 코어를 모두 연결해도 maxCore보다 작으면 볼 필요 없음
        if (connected + (processors.size() - depth) < maxCore) {
            return;
        }

        Position cur = processors.get(depth);

        // 4방향 확인
        for (int dir = 0; dir < 4; dir++) {

            if (canConnect(cur, dir)) {

                // 전선 설치 + 길이 반환
                int length = setWire(cur, dir, 2);

                solve(
                    depth + 1,
                    connected + 1,
                    wireLength + length
                );

                // 백트래킹 : 전선 제거
                setWire(cur, dir, 0);
            }
        }

        // 현재 코어를 연결하지 않는 경우
        solve(depth + 1, connected, wireLength);
    }

    // 해당 방향으로 가장자리까지 갈 수 있는지 확인
    static boolean canConnect(Position pos, int dir) {

        int y = pos.y + dy[dir];
        int x = pos.x + dx[dir];

        while (y >= 0 && y < N && x >= 0 && x < N) {

            // 코어나 기존 전선을 만나면 실패
            if (grid[y][x] != 0) {
                return false;
            }

            y += dy[dir];
            x += dx[dir];
        }

        return true;
    }

    // value = 2 : 전선 설치
    // value = 0 : 전선 제거
    // 설치/제거한 전선 길이 반환
    static int setWire(Position pos, int dir, int value) {

        int y = pos.y + dy[dir];
        int x = pos.x + dx[dir];

        int length = 0;

        while (y >= 0 && y < N && x >= 0 && x < N) {

            grid[y][x] = value;
            length++;

            y += dy[dir];
            x += dx[dir];
        }

        return length;
    }
}