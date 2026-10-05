import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // visited 배열 생성
        boolean[] visited = new boolean[n];
        
        // stack 생성
        Deque<Integer> stk = new ArrayDeque<>();
        
        // for (1 -> n 번 컴퓨터 까지)
        for (int i = 0; i < n; i++){
            // visited[i] == 0 이면 stack에 넣기 
            if (!visited[i]) {
                stk.push(i);
                visited[i] = true;
            }
            else continue;
            
            // stack()이 빌 때까지, DFS로 방문 체크
            while(!stk.isEmpty()){
                int cur = stk.pop();
                
                for (int j = 0; j < n; j++){
                    if (!visited[j] && computers[cur][j] == 1) {
                        visited[j] = true;
                        stk.push(j);
                    }
                }
            }
            
            // stack이 0이 되면 answer++
            answer++;
        }
        
        return answer;
    }
}