import java.util.*;

class Solution {
    
    public static int[] parent;
    public static int[] size;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 초기화
        parent = new int[n+1];
        size = new int[n+1];
        
        // 연결을 하나씩 무시하면서 wire 연결 하기
        for (int remove = 0; remove < wires.length; remove++){
            // 매 연결마다 초기화
            for (int i = 0; i <= n; i++){
                parent[i] = i;
                size[i] = 1;
            }
            
            
            for (int i = 0; i < n-1; i++){
                if (i == remove) continue;
                
                int a = wires[i][0];
                int b = wires[i][1];
                
                union(a, b);
            }
            
            // parent에 저장된 내용 카운트
            
            
            // 1번
            // printP();
            int rootA = find(1);
            int sizeA = size[rootA];
            int sizeB = n - sizeA;
            // answer = Math.min(Math.abs(sizeA- sizeB), answer);
            
            
            // 2번
            answer = Math.min(calc(n), answer);
            
            
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
    
    public static int find(int x){
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static void printP(){
        System.out.println(Arrays.toString(parent));
    }
    
    public static int calc(int n){
        int num1 = find(1);
        int num2 = -1;
        int num1_count = 0;
        int num2_count = 0;
        
        for (int i = 1; i <= n; i++){
            if (num1 != find(i) && num2 == -1){
                num2 = find(i);
            } 
            
            if (num1 == find(i)) num1_count++;
            if (num2 == find(i)) num2_count++;
        }
            
        // System.out.println("num1 : " + num1 + " num2 : " + num2);
        // System.out.println("num1 count : " + num1_count + " num2 count : " + num2_count);
            
        return Math.abs(num1_count - num2_count);
    }
}