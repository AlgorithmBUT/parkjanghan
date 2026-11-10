import java.util.*;

class Solution {
    public static int n;
    public static long answer;
    
    public long solution(int n, int[] times) {
        this.n = n;
        this.answer = 1_000_000_000;
        
        // 시간 복잡도 계산하기
        // 10억 바로 포기 -> log(N)
        
        long left = 1;
        
        int minTime = times[0];
        for (int time : times){
            minTime = Math.min(minTime, time);
        }
        long right = (long) times[0] * n;

        long mid;
        
        while(left <= right){
            // 계산하기
            mid = left + (right - left) / 2;
            long count = 0;
            
            for (int time : times){
                count += mid/time;
            }
            
            // System.out.println("count : " + count + " mid : " + mid);
            
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }

        }
        
        return answer;
    }
}