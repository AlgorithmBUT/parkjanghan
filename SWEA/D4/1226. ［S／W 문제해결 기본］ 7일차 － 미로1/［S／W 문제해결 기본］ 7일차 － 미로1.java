import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Position{
        int y; int x;

        public Position(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        for (int test_case = 1; test_case <= 10; test_case++){
            int tc = Integer.parseInt(br.readLine());
            int[][] grid = new int[16][16];
            Deque<Position> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[16][16];

            for (int i = 0; i < 16; i++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for (int j = 0; j < 16; j++){
                    grid[i][j] = str.charAt(j)-'0';
                    if (grid[i][j] == 2) {
                        q.offer(new Position(i, j));
                        visited[i][j] = true;
                    }
                }
                // System.out.println();
            }

            boolean isPossible = false;

            loop:
            while(!q.isEmpty()){
                Position cur = q.poll();

                for (int dir = 0; dir < 4; dir++){
                    int nextY = cur.y + dy[dir];
                    int nextX = cur.x + dx[dir];

                    if (nextY < 0 || nextY >= 16 || nextX < 0 || nextX >= 16) continue;
                    if (grid[nextY][nextX] == 1 || visited[nextY][nextX]) continue;

                    if (grid[nextY][nextX] == 3) {
                        isPossible = true;
                        break loop;
                    } else if (grid[nextY][nextX] == 0){
                        visited[nextY][nextX] = true;
                        q.offer(new Position(nextY, nextX));
                    }
                }

            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ").append(isPossible? 1 : 0);
            System.out.println(sb);
        }

    }
}