import java.util.*;

class Solution {
    static int[] info;
    static int answer;
    static List<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        this.info = info;
        
        graph = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edges){
            graph[e[0]].add(e[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);

        dfs(0, 0, candidates);
        
        return answer;
    }
    
    public static void dfs(int sheep, int wolf, List<Integer> candidates){
        
        answer = Math.max(answer, sheep);
        
        for (int candi : candidates){
            
            int nextSheep = sheep + (info[candi] == 0 ? 1 : 0);
            int nextWolf = wolf + (info[candi] == 1 ? 1 : 0);
            
            if (nextWolf >= nextSheep) continue;
            
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(Integer.valueOf(candi));
            nextCandidates.addAll(graph[candi]);
            
            dfs(nextSheep, nextWolf, nextCandidates);
            
        }
    }
    
}