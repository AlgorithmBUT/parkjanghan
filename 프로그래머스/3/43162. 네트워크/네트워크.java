import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        
        
        // make union
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0 ;j < n; j++){
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++){
            if (parent[i] == i) answer++;
        }
        return answer;
    }
    
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if (pa == pb) return;
        parent[pb] = pa;
    }
    
    public static int find(int num){
        if (num == parent[num]) return num;
        return find(parent[num]);
    }
}