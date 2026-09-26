import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{

    static int TC;
    static int N, MAX;
    static int ANSWER;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            MAX = -1;

            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    MAX = Math.max(MAX, map[i][j]);
                }
            }

            ANSWER = 0;
            visited = new boolean[N][N];
            for (int day = 0; day <= MAX; day++){
                ANSWER = Math.max(ANSWER, solve(day));
            }
            System.out.println("#" + tc + " " + ANSWER);
        }
    }

    public static int solve(int day){
        int count = 0;

        for (int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i =0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (visited[i][j] || map[i][j] <= day) continue;
                visited[i][j] = true;
                // System.out.println("push : " + i + " " + j);
                queue.offer(new int[] {i, j});

                while (!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int y = cur[0];
                    int x = cur[1];

                    for (int dir = 0; dir < 4; dir++){
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];

                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                        if (visited[ny][nx] || map[ny][nx] <= day) continue;
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        // System.out.println("push : " + ny + " " + nx);
                    }

                }

                count++;
            }
        }

        return count;
    }

}