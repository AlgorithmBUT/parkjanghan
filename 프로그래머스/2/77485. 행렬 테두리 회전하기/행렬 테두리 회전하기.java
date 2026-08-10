

class Solution {
    public int[] dy = {0, 1, 0, -1};
    public int[] dx = {1, 0, -1, 0};
    
    public int rotate(int[][] grid, int y1, int x1, int y2, int x2){
        
        
        x1--; y1--; x2--; y2--;
        // (2 2 5 4) -> (1 1 4 3)
        
        int y = y1;
        int x = x1;
        
        int temp = grid[y][x];
        int minnum = temp;
        
        for (int dir = 0; dir < 4; dir++){
            while(true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                
                if (ny > y2 || ny < y1 || nx > x2 || nx < x1) {
                    break;
                }
                
                int saved = grid[ny][nx];
                
                grid[ny][nx] = temp;
                temp = saved;
                
                minnum = Math.min(minnum, temp);
                
                y = ny;
                x = nx;
                
            }
        }
        return minnum;   
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] grid = new int[rows][columns];
        
        int count = 1;
        for (int y = 0; y < rows; y++){
            for (int x = 0; x < columns; x++){
                grid[y][x] = count++;
            }   
        }
        
        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0];
            int y1 = queries[q][1];
            int x2 = queries[q][2];
            int y2 = queries[q][3];
            
            answer[q] = rotate(grid, x1, y1, x2, y2);
        }
        
        
        // for (int y = 0; y < rows; y++){
        //     for (int x = 0; x < columns; x++){
        //         System.out.print(grid[y][x] + " ");
        //     }   
        //     System.out.println();
        // }
        
        return answer;
    }
}