import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] grid;
    public static boolean[][] visited;

    public static int startY, startX;

    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {

        for (int tc = 1; tc <= 10; tc++) {

            int test_case = Integer.parseInt(br.readLine());

            grid = new int[100][100];
            visited = new boolean[100][100];

            // 미로 입력
            for (int y = 0; y < 100; y++) {

                String str = br.readLine();

                for (int x = 0; x < 100; x++) {

                    grid[y][x] = str.charAt(x) - '0';

                    // 시작점 찾기
                    if (grid[y][x] == 2) {
                        startY = y;
                        startX = x;
                    }
                }
            }

            int answer = bfs();

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static int bfs() {

        Deque<Position> q = new ArrayDeque<>();

        q.offer(new Position(startY, startX));
        visited[startY][startX] = true;

        while (!q.isEmpty()) {

            Position cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {

                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                // 범위를 벗어나는 경우
                if (ny < 0 || ny >= 100 || nx < 0 || nx >= 100) {
                    continue;
                }

                // 벽인 경우
                if (grid[ny][nx] == 1) {
                    continue;
                }

                // 이미 방문한 경우
                if (visited[ny][nx]) {
                    continue;
                }

                // 도착점에 도착한 경우
                if (grid[ny][nx] == 3) {
                    return 1;
                }

                visited[ny][nx] = true;
                q.offer(new Position(ny, nx));
            }
        }

        return 0;
    }
}