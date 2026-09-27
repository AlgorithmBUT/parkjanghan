import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution{

    static int TC = 10;
    static int N;
    static int ANSWER;
    static int[][] map;
    static boolean[][] visited;

    static Pos start;
    static Pos end;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= TC; tc++){
            int temp = Integer.parseInt(br.readLine());
            map = new int[100][100];
            visited = new boolean[100][100];

            for (int i = 0; i < 100; i++){
                String str = br.readLine();
                for (int j = 0; j < 100; j++){
                    map[i][j] = str.charAt(j) - '0';
                    if (map[i][j] == 2) start = new Pos(i, j);
                    else if (map[i][j] == 3) end = new Pos(i, j);

                }
            }
            //================================
            // printMap();
            // System.out.println(start.y + " " + start.x);
            // System.out.println(end.y + " " + end.x);

            ANSWER = 0;
            Queue<Pos> queue = new ArrayDeque<>();
            visited[start.y][start.x] = true;
            queue.offer(start);

            outer :
            while (!queue.isEmpty()){
                Pos cur = queue.poll();

                for (int dir = 0; dir < 4; dir++){
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= 100 || nx < 0 || nx >= 100) continue;
                    if (visited[ny][nx] || map[ny][nx] == 1) continue;
                    if (ny == end.y && nx == end.x) {
                        ANSWER = 1;
                        break outer;
                    }
                    visited[ny][nx] = true;
                    queue.offer(new Pos(ny, nx));
                }
            }


            System.out.println("#" + tc + " " + ANSWER);
        }
    }

    public static class Pos {
        int y; int x;
        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static void printMap(){
        for (int i =0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}