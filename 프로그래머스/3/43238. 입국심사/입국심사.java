import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = n * (long)times[times.length - 1];
        long answer = right;
        
        while (left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int t : times){
                sum += mid / t;
                if (sum >= n) break;
            }
            
            // System.out.println(sum);
            
            if (sum >= n){
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}