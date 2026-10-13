import java.util.*;

class Solution {
    static int N;
    static boolean[][] grid;
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        grid = new boolean[N][N];
        List<Integer> candidates = new ArrayList<>();
        
        for (int[] e : edges){
            grid[e[0]][e[1]] = true;
        }

        for (int i = 0; i < N; i++){
            if (grid[0][i]) candidates.add(i);
        }
        
        answer = 1;
        
        dfs(1, 0, info, candidates);
        
        return answer;
    }
    
    public static void dfs(int sheep, int wolf, int[] info, List<Integer> candidates){
        
        answer = Math.max(sheep, answer);
        
        if (sheep <= wolf){
            return;
        }
        
        for (int node : candidates){
            List<Integer> newCandidates = new ArrayList<>(candidates);
            
            if (info[node] == 1){
                newCandidates.remove(Integer.valueOf(node));
                for (int i = 0; i < N; i++){
                    if (grid[node][i]) newCandidates.add(i);
                }
                dfs(sheep, wolf + 1, info, newCandidates);
                
            } else {
                newCandidates.remove(Integer.valueOf(node));
                for (int i = 0; i < N; i++){
                    if (grid[node][i]) newCandidates.add(i);
                }
                dfs(sheep + 1, wolf, info, newCandidates);
            }
            
        }
        
    }
}