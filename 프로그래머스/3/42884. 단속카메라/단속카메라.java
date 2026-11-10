import java.util.*;

class Solution {
    public static int answer = 0;
    public static int[][] routes;
    
    public int solution(int[][] routes) {
        this.routes = routes;
        
        // routes[i][0]가 작은 기준으로 sort(), 같은 경우 routes[i][1] 이 더 작은 수
        Arrays.sort(routes, (int[] a, int[] b)-> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int nextCamera = Integer.MIN_VALUE;
        
        
        // for (int[] route : routes){
        //     System.out.println(route[0] + " " + route[1]);
        // }
        
        for (int[] route : routes){
            int start = route[0];
            int end = route[1];
            
            if (nextCamera >= start && nextCamera <= end) continue;
            else if (nextCamera < start) {
                // System.out.print("[" + nextCamera + "], ");
                answer++;
                nextCamera = end;
            } else if (nextCamera > end) {
                nextCamera = end;
            }
        }
        
        // System.out.print("[" + nextCamera + "], ");
        
        return answer;
    }
}