import java.util.*;

class Solution {
    
    public class Position {
        int robot_y;
        int robot_x;
        int count; 
        
        public Position(int robot_y, int robot_x, int count){
            this.robot_y = robot_y;
            this.robot_x = robot_x;
            this.count = count;
        }
    }
    
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    
    public int solution(String[] board) {
        
        // 배열 형태로 입력
        int max_y = board.length;
        int max_x = board[0].length();
        char[][] grid = new char[max_y][max_x];
        boolean[][] visited = new boolean[max_y][max_x];
        
        int robot_y = -1; int robot_x = -1;
        int goal_y = -1; int goal_x = -1;
        
        for (int r = 0; r < max_y; r++){
            char[] ch_arr = board[r].toCharArray();
            for (int c = 0; c < max_x; c++){
                grid[r][c] = ch_arr[c];
                if (grid[r][c] == 'R') {
                    robot_y = r; robot_x = c;
                } else if (grid[r][c] == 'G'){
                    goal_y = r; goal_x = c;
                }
            }
        }
        
        Deque<Position> q = new ArrayDeque<>();
        q.offer(new Position(robot_y, robot_x, 0));
        
        while(!q.isEmpty()){
            Position p = q.poll();
            int ry = p.robot_y;
            int rx = p.robot_x;
            int count = p.count;
            
            // 큐 탈출 조건, Goal 지역에 로봇이 도착
            if (ry == goal_y && rx == goal_x) return count;

            for (int dir = 0; dir < 4; dir++){
                // Next 값 추가 +1
                int ny = ry; 
                int nx = rx;
                
                while(true){
                    // 종료 조건 : 범위 나가거나 장애물 만나면 한 칸 뒤로 돌리고 종료
                    int nextY = ny + dy[dir];
                    int nextX = nx + dx[dir];
                    
                    if (nextY < 0 || nextY >= max_y || nextX < 0 || nextX >= max_x || grid[nextY][nextX] == 'D'){                       break;
                    }
                    ny = nextY;
                    nx = nextX;
                }
                
                // 이동 불가할 경우 큐에 넣지 않음
                if (visited[ny][nx]) continue;
                
                visited[ry][rx] = true;
                q.offer(new Position(ny, nx, count + 1));
                
            }
        }
        
        return -1;
    }
}