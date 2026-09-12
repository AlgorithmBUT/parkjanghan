import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    public static char[] direction = {'>', 'v', '<', '^'};

    public static char[][] grid;

    public static int H, W;
    public static int posY, posX, posDir;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // input
            grid = new char[H][W];
            for (int i = 0; i < H; i++){
                String str = br.readLine();
                for (int j = 0; j < W; j++){
                    grid[i][j] = str.charAt(j);
                    if (grid[i][j] == '^' || grid[i][j] == 'v' || grid[i][j] == '<' || grid[i][j] == '>'){
                        posY = i;
                        posX = j;

                        if (grid[i][j] == '^') posDir = 3;
                        else if (grid[i][j] == 'v') posDir = 1;
                        else if (grid[i][j] == '>') posDir = 0;
                        else posDir = 2;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            Queue<Character> input = new ArrayDeque<>();
            String str = br.readLine();
            for (int i = 0; i < N; i++){
                input.offer(str.charAt(i));
            }

            while(!input.isEmpty()){
                char cur = input.poll();

                if (cur == 'S'){
                    shoot();
                    continue;
                }

                if (cur == 'R') posDir = 0;
                else if (cur == 'D') posDir = 1;
                else if (cur == 'L') posDir = 2;
                else if (cur == 'U') posDir = 3;

                grid[posY][posX] = direction[posDir];

                int nextY = posY + dy[posDir];
                int nextX = posX + dx[posDir];

                if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W || grid[nextY][nextX] != '.'){
                    continue;
                }
                grid[nextY][nextX] = direction[posDir];
                grid[posY][posX] = '.';
                posY = nextY;
                posX = nextX;
            }



            System.out.print("#" + test_case+ " ");
            printGrid();
        }

    }

    public static void shoot(){
        // 전차의 위치와 방향을 기준으로 shoot이 작동하게될 위치 찾기
        int shootY = posY + dy[posDir];
        int shootX = posX + dx[posDir];

        while (true){
            if (shootY < 0 || shootY >= H || shootX < 0 || shootX >= W) return;
            if (grid[shootY][shootX] == '#' || grid[shootY][shootX] == '*') {
                break;
            }

            shootY += dy[posDir];
            shootX += dx[posDir];
        }
        // 해당 위치에서 작용 내용 반영
        if (grid[shootY][shootX] == '*') grid[shootY][shootX] = '.';
    }

    public static void printGrid(){
        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

}