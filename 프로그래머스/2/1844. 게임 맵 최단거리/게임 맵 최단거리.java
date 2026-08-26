import java.util.*;

class Solution {
    
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    
    public class Position {
        int y; 
        int x;
        int d;
        
        public Position(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }        
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n+1][m+1];
        boolean find = false;
        
        Deque<Position> q = new ArrayDeque<>();
        
        Position start = new Position(1, 1, 1);
        visited[1][1] = true;
        q.offer(start);
        
        while (!q.isEmpty()){
            
            Position cur = q.poll();
            
            for (int dir = 0; dir < 4; dir++){
                int nextY = cur.y + dy[dir];
                int nextX = cur.x + dx[dir];
                int nextD = cur.d + 1;
                
                if (nextY <= 0 || nextY >= n + 1 || nextX <= 0 || nextX >= m + 1) continue;
                if (visited[nextY][nextX] || maps[nextY-1][nextX-1] == 0) continue;
                
                if (nextY == n && nextX == m){
                    answer = nextD;
                    find = true;
                    break;
                }
                
                visited[nextY][nextX] = true;
                q.offer(new Position(nextY, nextX, nextD));
            }
            
            if (find) break; 
        }
        
        return answer;
    }
}