import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int left = 1;
        int right = distance;
        int answer = right;
 
        Arrays.sort(rocks);
        
        while(left <= right){
            int mid = (left + right) / 2;   // 각 바위사이 거리의 최소값
            int sum = 0;
            int last = 0;
            int index = 0;
            for (index = 0; index < rocks.length; index++){
                int cur = rocks[index];
                int dist = cur - last;
                
                if (dist < mid){
                    sum++;
                } else {
                    last = cur;
                }
            }
            
            if (distance - last < mid){
                sum++;
            }
            
            if (sum <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        
        return answer;
    }
}