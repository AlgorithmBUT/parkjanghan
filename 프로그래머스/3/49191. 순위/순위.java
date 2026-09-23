import java.util.*;

class Solution {
    
    public static int[][] win;
        
    public int solution(int n, int[][] results) {
        
        win = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++){
            Arrays.fill(win[i], -1);
        }
        
        for (int[] result : results){
            win[result[0]][result[1]] = 1;
            win[result[1]][result[0]] = 0;
        }
        
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    if (win[i][k] == 1 && win[k][j] == 1){
                        win[i][j] = 1;
                        win[j][i] = 0;
                    } else if (win[i][k] == 0 && win[k][j] == 0){
                        win[i][j] = 0;
                        win[j][i] = 1;
                    }
                }
            }
        }
        
        printWin(n);
        System.out.println("---------------");
        
        int answer = 0;
        for (int i = 1; i <= n; i++){
            int unknown = 0;
            for (int j = 1; j <= n; j++){
                if (win[i][j] == -1) unknown++;
            }
            if (unknown == 1) answer++;
            System.out.println(unknown);
        }
        

        return answer;
    }
    
    public static void printWin(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.print(win[i][j] + " ");
            }
            System.out.println();
        }
    }
}