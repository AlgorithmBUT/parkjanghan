import java.util.*;

class Solution {
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    public static boolean[][] visited, tableVisited;
    public static int N;
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        visited = new boolean[N][N];
        tableVisited = new boolean[N][N];
        
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> pieces = new ArrayList<>();
        
        // 1. DFS로 게임 보드에서 조각 뽑아내기
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (visited[i][j] || game_board[i][j] == 1) continue;
                
                List<int[]> shape = dfs(game_board, i, j);
                blanks.add(shape);
                
                // for (int[] p : shape){
                //     System.out.println(Arrays.toString(p));
                // }
                // System.out.println("===========");
            }
        }
        
        // 2. 테이블에서 DFS로 조각 뽑아내기
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (tableVisited[i][j] || table[i][j] == 0) continue;
                List<int[]> shape = dfsTable(table, i, j);
                pieces.add(shape);
                
            }
        }
        
        // 3. 조각을 돌려가며 blank랑 비교
        int answer = 0;
        boolean[] used = new boolean[blanks.size()];
        
        for (List<int[]> piece : pieces){
            outer : 
            for (int r = 0; r < 4; r++){
                
                for (int i = 0; i < blanks.size(); i++){
                    if (used[i]) continue;
                    
                    List<int[]> blank = blanks.get(i);
                    
                    if (isSame(piece, blank)){
                        used[i] = true;
                        answer += piece.size();
                        break outer;
                    }
                }
                
                piece = rotate(piece);
            }
  
        }
        return answer;
    }
    
    public static List<int[]> dfs(int[][] game_board, int sy, int sx){
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        
        visited[sy][sx] = true;
        queue.offer(new int[] {sy, sx});
        shape.add(new int[] {sy, sx});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for (int dir = 0; dir < 4; dir++){
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx] || game_board[ny][nx] == 1) continue;
                
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
                shape.add(new int[]{ny, nx});
            }
        }
        
        return normalize(shape);
    }
    
    public static List<int[]> dfsTable(int[][] table, int sy, int sx){
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        
        tableVisited[sy][sx] = true;
        queue.offer(new int[] {sy, sx});
        shape.add(new int[] {sy, sx});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for (int dir = 0; dir < 4; dir++){
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (tableVisited[ny][nx] || table[ny][nx] == 0) continue;
                
                tableVisited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
                shape.add(new int[]{ny, nx});
            }
        }
        
        return normalize(shape);
    }
    
    public static List<int[]> normalize(List<int[]> shape){
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        
        for (int[] p : shape){
            minY = Math.min(p[0], minY);
            minX = Math.min(p[1], minX);
        }
        
        for (int[] p : shape){
            p[0] -= minY;
            p[1] -= minX;
        }
        
        shape.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        return shape;
    }
    
    public static List<int[]> rotate(List<int[]> shape){
        List<int[]> rotated = new ArrayList<>();

        for (int[] p : shape){
            int y = p[0];
            int x = p[1];
            
            rotated.add(new int[]{x, -y});
        }
 
        return normalize(rotated);
    }
    
    public static boolean isSame(List<int[]> a, List<int[]> b){
        if (a.size() != b.size()) return false;
        
        for (int i = 0; i < a.size(); i++){
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }
        
        return true;
    }
}