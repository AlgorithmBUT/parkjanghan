import java.util.*;

class Solution {
    static int[] parent;
    static int[] size;
    
    public int solution(int n, int[][] computers) {
        
        
        // make union
        parent = new int[n];
        size = new int[n];
        
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = i+1 ;j < n; j++){
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
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) return;
        
        if (size[rootA] < size[rootB]){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }
    
    public static int find(int num){
        if (num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}