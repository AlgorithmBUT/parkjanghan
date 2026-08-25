import java.util.*;

class Solution {
    
    int result = Integer.MAX_VALUE;
    
    public void checkOrder(int[] nextDist, int[] dist, int[] order){
        int nodeNum = nextDist.length; 
        
        for (int start = 0; start < nodeNum; start++){
            int currentNode = start;
            int checkedNode = 0;
            
            for (int i = 0; i < order.length; i++){
                int remainDist = dist[order[i]]; 
                int nextDistance = nextDist[currentNode];
                
                checkedNode++;
                
                while(checkedNode < nodeNum && remainDist >= nextDistance){
                    remainDist -= nextDistance;
                    checkedNode++;
                    currentNode = (currentNode + 1) % nodeNum;
                    nextDistance = nextDist[currentNode];
                }
                
                // 방문 완료
                if (checkedNode == nodeNum){
                    result = Math.min(result, i + 1);
                    break;
                }
                
                // 방문 실패 -> 다음 친구에게 넘김
                currentNode = (currentNode + 1) % nodeNum;
            }    
            
            
        }
    }
    
    public void solve(int n, int[] nextDist, int[] dist, boolean[] visited, int[] order, int depth){
        if (depth == dist.length){
            // 리턴 처리 필요
            // System.out.println(Arrays.toString(order));
            checkOrder(nextDist, dist, order);
            return;
        }
        
        for (int i = 0; i < dist.length; i++){
            if (visited[i]) continue;
            
            visited[i] = true;
            order[depth] = i;
                
            solve(n, nextDist, dist, visited, order, depth + 1);
            
            visited[i] = false;
        }
        
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        
        int[] nextDist = new int[weak.length];
        for (int i = 0; i < weak.length; i++){
            int nextIdx = (i+1) % weak.length;
            nextDist[i] = (weak[nextIdx] - weak[i] + n) % n;
        }
        
        // System.out.println(Arrays.toString(nextDist));
        boolean[] visited = new boolean[dist.length];
        int[] order = new int[dist.length];
        
        solve(n, nextDist, dist, visited, order, 0);
        
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }
}