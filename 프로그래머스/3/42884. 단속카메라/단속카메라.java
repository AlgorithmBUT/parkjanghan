import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        int cur = -30000;      // 카메라 위치
        int camera = 0;   // 카메라 개수

        Arrays.sort(routes, (a,b) ->{
          return Integer.compare(a[1], b[1]);
        });

        for (int i=0; i<routes.length; i++){
          if (routes[i][0]<=cur){
            continue;
          } else {
            cur=routes[i][1];
            camera++;
          }
        }

        return camera;
    }
}